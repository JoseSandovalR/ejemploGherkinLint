Feature: Registro de usuarios

  Scenario: Crear un nuevo usuario
    Given que soy un usuario nuevo
    When ingreso mis datos personales
    Then se crea una cuenta exitosamente
    
Feature: Inicio de sesión

  Scenario: Iniciar sesión exitosamente
    Given que tengo una cuenta registrada
    When ingreso mis credenciales
    Then inicio sesión correctamente
