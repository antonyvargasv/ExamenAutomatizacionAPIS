@PruebaPetStoreOrder
Feature: PetSore API - Order

  @CrearOrder
  Scenario Outline: Crear order
    Given la url es "https://petstore.swagger.io/v2"
    When creo el order con  <id>, <petId> y <quantity>
    Then valido el codigo de respuesta sea <codigoResponse>

    Examples:
      | id  | petId | quantity | codigoResponse |
      | 100 | 100   | 30       | 200            |
      | 200 | 200   | 80       | 200            |
      | 300 | 300   | 100      | 200            |

  @ConsultaOrder
  Scenario Outline: Consulta Order por orderId

    Given la url es "https://petstore.swagger.io/v2"
    When consulto el order con <petId>
    Then valido el codigo de respuesta sea <codigoResponse>
    Examples:
      | id  | petId | quantity | status | complete | codigoResponse |
      | 100 | 100   | 30       | placed | true     | 200            |
      | 200 | 200   | 80       | placed | true     | 200            |
      | 300 | 300   | 100      | placed | true     | 200            |


