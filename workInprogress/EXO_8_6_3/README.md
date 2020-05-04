- L'organisation des classe se trouve sur le photo 
  diagramme.png

- Pour les classe j'ai utilisé l'interface Drawable pour dessiner 
  des figure et l'interface Deplacement pour déplacer les figures.
  La classe abstraite Figure implément l'interface Drawable et Deplacement.
  Cette classe permet d'utiliser le polymorphisme pour mieux gérer les figures 
  dans le composant ContainerFigure. Ainsi une figure peut être soit un cercle,
  soit un rectangle et soit un carré. Enfin j'ai crée une classe Window qui
  représente notre interface graphique et le composant panel de cette classe est
  la ContainerFigure qui herite la classe JPanel de java.swing.

- Il y a aussi les classes SerializeDrawing et DeserializeDrawing qui permettent 
  respectivement de sérialiser et de desérialiser les figures.
  Pour la sérialisation,  les données sérialisées se trouve dans
  le fichier figure.txt.
  
- Le programme principale se trouve dans la classe 
  Window.
  
- L'exécution du programme peut se faire par la commande 
  'make' et la suppression des fichier .class se fait avec
  la commande 'make clean'.
  