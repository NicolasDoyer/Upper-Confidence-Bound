# Upper Confidence Bound

TP UCB 

## Compilation du projet

Lancer dans le dossier "src" du projet :

```sh
javac *.java
```

## Utilisation

Lancer dans le dossier "src" du projet :

```sh
java Main
```

## Stratégies

UCB: le paramètre K gère l'exploration de l'UCB. Plus K est grand, plus l'UCB explore. Plus il est petit, plus il se rapprochera du fonctionnement du glouton.

Gloutone: Meilleure dans le cas où la variance est faible voire nulle. Par exemple, si la variance est grande, il est probable que cette stratégie se trompe totalement.

UCB: Meilleur lorsque la variance est grande. Elle est meilleure pour discerner les "fausses bonnes machines".