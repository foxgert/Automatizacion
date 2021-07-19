# language: es
  Característica: Funcionalidad del carrito de compra version 2
@smoke
    Escenario: Compra de un producto version 2
      Dada que la web esta operativa
      Cuando se genera el número de tarjeta
      Y selecciona la cantidad "2"
      Y realiza la compra del producto
      E ingresa los datos de la tarjeta
      Y paga el producto
      Entonces validar el mensaje de pago "Payment successfull!"

@regresion
    Esquema del escenario: : Compra un producto con varias cantidades version 2
      Dada que la web esta operativa
      Cuando se genera el número de tarjeta
      Y selecciona la cantidad "<cantidad>"
      Y realiza la compra del producto
      E ingresa los datos de la tarjeta
      Y paga el producto
      Entonces validar el mensaje de pago "<mensaje>"
      Ejemplos: Tabla de cantidades
      |cantidad|mensaje|
      |3       | Payment successfull!    |
      |1       | Payment successfull!    |
      |5       | Payment successfull!    |



