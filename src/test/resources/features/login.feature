Feature: Authentification utilisateur

  Scenario: Connexion avec des identifiants valides
    Given l'utilisateur est sur la page de connexion
    When l'utilisateur se connecte avec des identifiants valides
    Then l'utilisateur doit accéder à la page des produits