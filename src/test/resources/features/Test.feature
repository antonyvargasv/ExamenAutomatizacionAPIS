@TestAssertion
Feature: Test Assertion

  Scenario Outline: prueba de login exitoso
    Given prueba de assertion
    When pruebo un servicio url "http://www.google.com"
    When inicio sesion con "<usuario>" y "<clave>"

    Examples:
      | usuario | clave |
      | antony  | an123 |
      | danitza | da123 |
