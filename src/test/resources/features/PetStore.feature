Feature: PetSore API
  @Consulta
  Scenario: Consulta mascota

    Given la url es "https://petstore.swagger.io/v2"
    When consulto la mascota con ID "2"
    Then valido el codigo de respuesta sea 200
    And valido el nombre de la mascota sea "Pinky"


@CrearMasota
  Scenario: Crear mascota

    Given la url es "https://petstore.swagger.io/v2"
    When creo la mascota "Rocky" con ID "345"
    Then valido el codigo de respuesta sea 200