# Système de Simulation Ferroviaire

Ce projet Java simule un système ferroviaire avec des trains se déplaçant entre des stations et des sections de voies ferrées. 

## Packages:
- train0: le premier package prend en compte les contraintes de l'exercice 1 (un seul train sur la ligne).

- train1: le deuxième package prend en compte les contraintes de l'exercice 2 (Plusieurs trains sur la ligne).

- train2: ce dernier package prende en compte les contraintes de l'exercice 3  (Éviter les interblocages...).


Ce projet comprend des classes pour représenter les trains, les stations, les sections et le réseau ferroviaire lui-même.

En plus des packages, il y a également un fichier pdf nommé Réponses.pdf qui contient les réponses aux différentes questions ainsi que le diagramme de classes correspondant à chacun des trois packages.

## Main
- La classe principale du programme. Elle est présente dans tous les packages. Elle initialise le système ferroviaire, les stations, les sections et les trains, et lance leurs threads pour la simulation. Elle nous permet de faire des tests pour vérifier est ce que notre programme répond aux différentes contraintes des exercices.

## BadPositionForTrainException
- Cette classe d'exception est levée lorsqu'on tente de placer un train dans une position invalide.

## Direction
- Enumération représentant la direction qu'un train peut prendre : de gauche à droite ou de droite à gauche.

## Element
- Classe abstraite représentant un élément générique du système ferroviaire, soit une station, soit une section de voie ferrée.

## Position
- Représente la position d'un train dans le circuit, composée d'un élément et d'une direction. Fournit des méthodes pour manipuler la position et déterminer la position suivante.

## Railway
- Représente le système ferroviaire, composé d'éléments (stations et sections). Fournit des méthodes pour continuer le déplacement des trains le long du réseau ferré.

## Section
- Représente une section de voie ferrée. Hérite de la classe `Element`.

## Station
- Représente une gare ferroviaire avec un nom et un nombre de quais. Hérite de la classe `Element`.

## Train
- Représente un train se déplaçant le long du système ferroviaire. Il a un nom, une position et des stations de départ et d'arrivée. Implémente l'interface `Runnable` pour le multithreading.

## Utilisation
- Pour utiliser le programme, lancez simplement la classe `Main`. Elle initialisera le système ferroviaire, créera des trains et lancera leurs threads pour la simulation.

## Les diffécultés rencontrées
Parmi les  difficultés rencontrées dans ce projet de simulation de réseau ferroviaire, on peut citer : 

- Synchronisation multithread : Gérer plusieurs trains se déplaçant simultanément sur le réseau nécessite une synchronisation précise pour éviter les conflits et garantir un fonctionnement cohérent. 

- Modélisation des interactions : Concevoir des classes pour représenter efficacement les trains, les sections de voie et les stations, tout en permettant des interactions fluides entre eux, a été un défi. 

- Prévention des interblocages : Éviter les situations où deux trains pourraient se bloquer mutuellement a demandé la mise en place de mécanismes de détection et de prévention des interblocages et nous a pris un temps important par rapport aux autres exercices . 

- Débogage et test : Identifier et corriger les erreurs de logique, de synchronisation ou de comportement dans le système a demandé des efforts de débogage approfondis et la création de cas de test complets. 

En surmontant ces difficultés, nous avons réussi à créer une simulation fonctionnelle et robuste du réseau ferroviaire, capable de modéliser  le déplacement des trains tout en assurant et en évitant les interblockages.

## Auteurs
- AAGOUR Fouad
- LAGSSAIBI Adam

