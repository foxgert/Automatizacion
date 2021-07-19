# language: es
  @primerafuncionalidad
  Característica: Funcionalidad del carrito de compra
@smoke
    Escenario: Compra de un producto
      Dada que la web esta operativa
      Cuando se genera el número de tarjeta
      Y selecciona la cantidad "5"
      Y realiza la compra del producto
      E ingresa los datos de la tarjeta
      Y paga el producto
      Entonces validar el mensaje de pago "Payment successfull!"

@regresion
    Esquema del escenario: : Compra un producto con varias cantidades
      Dada que la web esta operativa
      Cuando se genera el número de tarjeta
      Y selecciona la cantidad "<cantidad>"
      Y realiza la compra del producto
      E ingresa los datos de la tarjeta
      Y paga el producto
      Entonces validar el mensaje de pago "<mensaje>"
      Ejemplos: Tabla de cantidades
      |cantidad|mensaje|
      |4       | Payment successfull!    |
      |6       | Payment successfull!    |
      |8       | Payment successfull!    |


    Escenario: Validación de tarjeta en blanco
      Dado que la web esta operativa
      Cuando selecciona la cantidad "3"
      Y realiza la compra del producto
      Y selecciona el mes "04"
      Y selecciona el año "2024"
      Y paga el producto
      Entonces validar el mensaje del cuadro de dialogo "Check card number is 16 digits!"

