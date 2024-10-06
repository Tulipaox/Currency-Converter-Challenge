package br.com.metodoscurrency;

import java.util.Date;

public class money {
    private final Date createdAt;
    private final String base_code;
    private final String target_code;
    private final double conversion_rate;
    private final double conversion_result;
    private double ammount;

    public money(recordObj recordObj) {
        this.base_code = recordObj.base_code();
        this.target_code = recordObj.target_code();
        this.conversion_rate = recordObj.conversion_rate();
        this.conversion_result = recordObj.conversion_result();
        this.createdAt = new Date();
    }

    // Getters
    public String getBase_code() {
        return base_code;
    }


    public String getTarget_code() {
        return target_code;
    }

    public double getAmmount() {
        return ammount;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    @Override
    public String toString() {
        return """
               *******************************************************
                Valor: %2.2f
                Moeda Base: %s
                Moeda Alvo: %s
                Taxa de Conversão: %2.2f
                Valor Convertido: %2.2f
                Hora da Conversão: %s
               *******************************************************\s
               \s""".formatted(ammount, base_code, target_code, conversion_rate, conversion_result, createdAt);
     }
}
