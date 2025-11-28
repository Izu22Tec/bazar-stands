package com.bazar.stands;

import com.bazar.stands.service.ReporteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReporteServiceTest {

    @Test
    void pruebaSumaIngresos() {
        ReporteService service = new ReporteService();
        // solo probamos que no truene
        Assertions.assertDoesNotThrow(() -> service.ingresosTotales());
    }
}
