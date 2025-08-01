Feature: Notificación de transacción por email

  @CompraAprobada
  Scenario: Usuario recibe notificación por email ante compra aprobada
    Given el usuario con DNI "30233365" y email enrolado
    When realiza una compra con tarjeta "MC-CR" de $15000 con autorización "5123"
    Then se genera una notificación con estado "APROBADA"

  @CompraRechazada
  Scenario: Usuario no recibe notificación ante compra rechazada
    Given el usuario con DNI "30233365" y email enrolado
    When realiza una compra con tarjeta "MC-CR" de $15000 con autorización "DECLINED"
    Then se genera una notificación con estado "RECHAZADA"
