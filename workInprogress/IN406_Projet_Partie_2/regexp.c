#include "regexp.h"
#include <string.h>

ADERIV nouvel_arbre(STATE s, char c){
	ADERIV a = malloc(sizeof(struct aderiv));
	if(!a) {printf("Plus de mémoire, malloc a échoué.\n"); exit(5);}
	a->s = s;
	a->caractere = c;
	a->fils[0] = NULL;
	a->fils[1] = NULL;
	a->fils[2] = NULL;
	return a;
}

void liberer_arbre(ADERIV a){
	if(a){
		for(int i = 0; i < 3; i++) liberer_arbre(a->fils[i]);
		free(a);
	}
}


int caractere_courant_char(char c){//retourne l'caractere_courant correspondant au caractère dans le tableau des états
	switch(c){
		case '+': return 0;
		case '.': return 1;
		case '*': return 2;
		case '(': return 3;
		case ')': return 4;
		case '#': return 6;
		default:
			if( c >= 'a' && c <= 'z') return 5;
			printf("Caractère inconnu dans l'expression régulière.\n");
			exit(3);
	}
}

int get_symbole_terminal(int caractere_courant)
{
	switch (caractere_courant)
	{
	case 0: return PLUS;
	case 1: return POINT;
	case 2: return ETOILE;
	case 3: return PARO;
	case 4: return PARF;
	case 5: return CAR;
	default:
		return -1;
		break;
	}
}

ADERIV chercher_noeud_courant(ADERIV a, STATE s)
{
	if( !a ) return NULL;
	if( !a->fils[0] && !a->fils[1] && !a->fils[2] && s == a->s ) return a;
	
	ADERIV ar = chercher_noeud_courant(a->fils[0], s);
	if( !ar )
	{
		ar = chercher_noeud_courant(a->fils[1], s);
		if( !ar )
		{
			ar = chercher_noeud_courant(a->fils[2], s);
			if( !ar ) 
				return NULL;
			else return ar;
		}
		else return ar;
	}
	else return ar;

}

ADERIV construire_arbre_derivation(char *expr){
	STATELISTE table[7][7] = {//cette table représente la table des transitions de l'énoncé
		{{-1},{-1},{-1},{2,{A,B}},{-1},{2,{A,B}},{-1}}, // transition quand le STATE S est lu
		{{-1},{-1},{-1},{2,{C,D}},{-1},{2,{C,D}},{-1}},//STATE A
		{{3,{PLUS,A,B}},{-1},{-1},{-1},{0},{-1},{1,{CAR}}},//STATE B
		{{-1},{-1},{-1},{2,{E,F}},{-1},{2,{E,F}},{-1}},//STATE C
		{{0},{3,{POINT,C,D}},{-1},{-1},{0},{-1},{0}},//STATE D
		{{0},{0},{0},{3,{PARO,S,PARF}},{-1},{1,{CAR}},{-1}},//STATE E
		{{0},{0},{2,{ETOILE,F}},{-1},{0},{-1},{0}}//STATE F
	};
	//Une STATELISTE de taille 0 correspond à une règle dont la production est epsilon.
	//Une STATELISTE de taille -1 correspond à une erreur (expression rejetée)
	int taille		      = strlen(expr);
	PILE p 				  = nouvelle_pile(taille*2);
	PILE parenthese       = nouvelle_pile(taille); //Pile qui vérifie les parenthéses.
	int caractere_courant = caractere_courant_char(expr[0]), position = 0;
	p 					  = empiler(p, S);
	ADERIV racine 		  = nouvel_arbre(S, 0); //la racine de l'arbre de dérivation
	int caracter;

	while (position < taille )		
	{
		int symbole = p.contenu[p.sommet - 1]; 
		if( symbole < 7 ) // symbole non terminal.
		{
			if( table[symbole][caractere_courant].taille == - 1 ) 
			{	
				printf("********************************\n");
				printf("****** Mot Non Reconnu :( ******\n");
				printf("********************************\n\n");
				
				return NULL;
			}
			else
			{
				int etat_depiler = depiler(&p);

				/*
					On cherche a rattaché les nouveaux fils à leurs parents dans 
					l'arbre de dérivation de manière récursive avec la fonction
					chercher_noeud_courant(...) définit au dessus de la fonction 
					construire_arbre_dérivation.
				*/
				ADERIV pere = chercher_noeud_courant(racine, etat_depiler);

				if( table[symbole][caractere_courant].taille > 0 )
				{
					int tailles = table[symbole][caractere_courant].taille;
					for ( int i = tailles - 1; i >= 0; i-- )
					{	
						STATE etat    = table[symbole][caractere_courant].liste[i];
						p 		      = empiler(p, etat);
						caracter      = ( etat >= 7) ? expr[position]: 0;//Symbole terminal.
						
						// Vérification des parenthése Question 2).

						if( caractere_courant == 3 ) //Parenthése Ouvrant.
							empiler(parenthese, PARO);
						if( caractere_courant == 4 ) //Parenthése fermant.
							depiler(&parenthese);

						//Fin de la vérification des parenthése QUESTION 2).

						//Vérification du caractére fin de mot.
						if( caractere_courant != 6 )
						{
							ADERIV fils   = nouvel_arbre(etat, caracter);
							pere->fils[(tailles - 1) - i] = fils;
						}

					}
					if( caractere_courant == 6 )
					{
						depiler(&p);
						++position;
					}
				}
			}
		}
		else // symbole terminal
		{
			if( symbole != get_symbole_terminal(caractere_courant) ) 
			{
				printf("*****************************\n");
				printf("**** Mot Non Reconnu :( *****\n");
				printf("*****************************\n\n");
				return NULL;
			}
			else
			{
				depiler(&p);
				caractere_courant = caractere_courant_char(expr[++position]);
			}	
		}
		//affiche_pile(p);
	}

	//Vérification si le mot est reconnu avec le bonne parenthése.
	if( position == taille && est_vide(p) && est_vide(parenthese))
	{	
		printf("************************\n");
		printf("**** Mot Reconnu ! *****\n");
		printf("************************\n\n");
	}
	else 
	{
		printf("****************************\n");
		printf("**** Mot Non Reconnu :( ****\n");
		printf("****************************\n\n");
	}

	return racine;
}

void affiche_aderiv(ADERIV a, int space){//rendre joli
	//affiche les fils de gauche à droite
	if(a){
		affiche_aderiv(a->fils[2], space + 1);
		affiche_aderiv(a->fils[1], space + 1);
		for(int i = 0; i < space; i++) printf("   ");
		affiche_state(a->s);
		if(a->s == CAR) printf(" : %c",a->caractere);
		printf("\n");
	    affiche_aderiv(a->fils[0], space + 1);
	}
}