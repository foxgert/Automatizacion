package definitions;

import io.cucumber.java.es.*;
import pageobjects.*;

import java.io.IOException;

import static support.util.evidencia;

public class carritoDefinition {
    menuPage menu;
    tarjetaPage tarjeta;
    carritoPage carrito;
    pagoPage pago;
    confirmacionPage confirmacion;


    public carritoDefinition() {
        menu = new menuPage();
        tarjeta = new tarjetaPage();
        carrito = new carritoPage();
        pago = new pagoPage();
        confirmacion = new confirmacionPage();
    }

    @Dada("que la web esta operativa")
    public void queLaWebEstaOperativa() {
        hooks.driver.get("http://demo.guru99.com/payment-gateway/purchasetoy.php");
    }

    @Cuando("se genera el número de tarjeta")
    public void seGeneraElNumeroDeTarjeta() throws IOException {
        menu.clickGenerarTarjeta();
        menu.ventanaActiva();
        tarjeta.obtenerNroTarjeta();
        tarjeta.obtenerCVV();
        tarjeta.obtenerFecha();
        evidencia();
        tarjeta.ventanaInicial();
    }

    @Y("selecciona la cantidad {string}")
    public void seleccionaLaCantidad(String cant) throws IOException {

        carrito.seleccionarCantidad(cant);
        evidencia();
    }

    @Y("realiza la compra del producto")
    public void realizaLaCompraDelProducto() {
        carrito.clickComprar();
    }

    @E("ingresa los datos de la tarjeta")
    public void ingresaLosDatosDeLaTarjeta() throws IOException {
        pago.escribirNroTarjeta(tarjetaPage.nro_tarjeta);
        pago.seleccionarMes(tarjetaPage.mes);
        pago.seleccionarAnio(tarjetaPage.anio);
        pago.escribirCVV(tarjetaPage.cvv);
        evidencia();
    }

    @Y("paga el producto")
    public void pagaElProducto() {
        pago.clickPagar();
    }

    @Entonces("validar el mensaje de pago {string}")
    public void validarElMensajeDePago(String mensaje) throws IOException {
        confirmacion.validarMensaje(mensaje);
        evidencia();
        confirmacion.mostrarCodigo();
    }
}
