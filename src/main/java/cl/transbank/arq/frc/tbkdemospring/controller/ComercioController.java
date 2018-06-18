package cl.transbank.arq.frc.tbkdemospring.controller;

import cl.transbank.arq.frc.tbkdemospring.model.Comercio;
import cl.transbank.arq.frc.tbkdemospring.model.Sucursal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class ComercioController {
    private final static String API_PREFIX = "/comercio";
    private final static Random RANDOMIZER  = new Random();

    @RequestMapping(path = API_PREFIX+"/{rut}")
    public Comercio getComercio (@PathVariable(name = "rut") String rut) {
        return this.createDummy(rut);
    }

    @RequestMapping(path = API_PREFIX+"/{rut}/sucursales")
    public List<Sucursal> listSucursales(@PathVariable(name = "rut") String rut){
        return this.createDummyListSucursales(rut);
    }

    private List<Sucursal> createDummyListSucursales(String rut) {
        final List<Sucursal> sucursales = new ArrayList<>();
        for( int i = 0 ; i<20; i++ ){
            Sucursal sucursal = new Sucursal();
            sucursal.setAddress( "Avenida Siempreviva #742" );
            sucursal.setCodigo( this.createCodigo() );
            sucursales.add( sucursal );
        }
        return sucursales;
    }

    private String createCodigo() {
        String out = "";
        for (int i=0; i<3; i++)
            out += RANDOMIZER.nextInt((9) + 1);
        return out;
    }

    private Comercio createDummy(String rut) {
        final  Comercio comercio = new Comercio();
        comercio.setRut( rut );
        comercio.setId( String.valueOf( RANDOMIZER.nextInt((100000 - 10000) + 1) + 10000) );
        comercio.setNombre( "Transbank S.A." );
        return comercio;
    }

}
