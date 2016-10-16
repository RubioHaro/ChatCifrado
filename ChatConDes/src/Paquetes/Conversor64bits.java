package Paquetes;

import java.math.BigInteger;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alumno
 */
public class Conversor64bits {

    public Conversor64bits() {
    }

    public String ConvertBinToHexa(char[] concatenacionFinal) {
        String Final = "";
        
        for (int e = 0; e < 64;) {
            String Hexa = "";
            for (int i = 0; i < 4; ++i) {
                Hexa = Hexa + concatenacionFinal[i + e];
            }
            e = e + 4;
            Final = Final + new BigInteger(Hexa, 2).toString(16);
        }
        return Final;
    }

    public String ConvertToBin(String Cadenita) {
        if (validar(Cadenita)) {
            String bin = Binarizar(Cadenita);
            return bin;
        } else {
            return "Error";
        }
    }

    public int StringToBinary(String numeroBinario) {
        int num = Integer.parseInt(numeroBinario, 2);
        return num;
    }

    public String Binarizar(String Cadenita) {
        //---------------*******----------------\\
        //Desarmamos la cadena en un arreglo:
        int tamañoCadena = Cadenita.length();
        char[] ArregloCadena = new char[tamañoCadena];
        for (int i = 0; i < tamañoCadena; ++i) {
            ArregloCadena[i] = Cadenita.charAt(i);
        }
        //---------------*******----------------\\

        int num = 0;
        String[] ArregloBinarios;
        ArregloBinarios = new String[tamañoCadena];
        String BinFinal = "";

        for (int i = 0; i < tamañoCadena; ++i) {

            num = Character.getNumericValue(ArregloCadena[i]);
            switch (Integer.toBinaryString(num).length()) {
                case 0:
                    ArregloBinarios[i] = "0000";
                    break;
                case 1:
                    ArregloBinarios[i] = "000" + Integer.toBinaryString(num);
                    break;
                case 2:
                    ArregloBinarios[i] = "00" + Integer.toBinaryString(num);
                    break;
                case 3:
                    ArregloBinarios[i] = "0" + Integer.toBinaryString(num);
                    break;
                case 4:
                    ArregloBinarios[i] = "" + Integer.toBinaryString(num);
                    break;
                default:
                    break;
            }
            BinFinal = BinFinal + ArregloBinarios[i];
        }
        return BinFinal;
    }

    public String BinarizarCifrasDosDigitos(int numero) {
        String NumBin = Integer.toBinaryString(numero);
        String BinFinal = "";
        switch (NumBin.length()) {
            case 1:
                BinFinal = "000" + NumBin;
                break;
            case 2:
                BinFinal = "00" + NumBin;
                break;
            case 3:
                BinFinal = "0" + NumBin;
                break;
            case 4:
                BinFinal = NumBin;
                break;
            default:
                break;
        }
        return BinFinal;
    }

    public boolean validar(String cadenita) {
        return !cadenita.equals("");
    }
}
