package Paquetes;

import java.util.Arrays;

/*
 * New Ligths
 * Services info Web
 * Rubio Haro 
 */
/**
 *
 * @author Rod
 */
public class CIFRAR {

    private String ClaveBin;
    private String DatoBin;

    public String CIFRAR(String datoHexa, String Clave, int opc) {
        String finalS;
        ObjetoClaves ObjectsClaves = ProcesoDeClave(Clave);
        switch (opc) {
            case 1:
                finalS = ProcesoDeDatoCifrar(datoHexa, ObjectsClaves);
                break;
            case 2:
                finalS = ProcesoDeDatoDescifrar(datoHexa, ObjectsClaves);
                break;
            default:
                finalS = "";
                break;
        }
        return finalS;
    }

    public String ProcesoDeDatoCifrar(String datoHexa, ObjetoClaves claves) {
        try {
            Conversor64bits Binario = new Conversor64bits();
            DatoBin = Binario.ConvertToBin(datoHexa);

            CajaDePermutacion ObejetoDePermutacion = new CajaDePermutacion();
            char[] num = ObejetoDePermutacion.PermutedIP(DatoBin);
            char[] L = new char[32];
            char[] R = new char[32];
            for (int i = 0; i < 32; ++i) {
                L[i] = num[i];
                R[i] = num[i + 32];
            }
            ObjetoDatos Datito = new ObjetoDatos();
            Datito.setL0(L);
            Datito.setR0(R);
            char[] ER = ObejetoDePermutacion.PermutedExpancion(Datito.getR0());
            char[] k1 = claves.getK1();
            char[] ResultXor0 = functionXor(ER, k1);
            String F_SB_0 = Get_Claves_B(ResultXor0);

            char[] F1 = ObejetoDePermutacion.PermutedP(F_SB_0);
            char[] ResultXor_a1 = functionXor(F1, Datito.getL0());
            Datito.setR1(ResultXor_a1);
            Datito.setL1(Datito.getR0());
            char[] ER1 = ObejetoDePermutacion.PermutedExpancion(Datito.getR1());
            char[] ResultXor_b1 = functionXor(ER1, claves.getK2());
            String F_SB_1 = Get_Claves_B(ResultXor_b1);

            char[] F2 = ObejetoDePermutacion.PermutedP(F_SB_1);
            char[] ResultXor_a2 = functionXor(F2, Datito.getL1());
            Datito.setR2(ResultXor_a2);
            Datito.setL2(Datito.getR1());
            char[] ER2 = ObejetoDePermutacion.PermutedExpancion(Datito.getR2());
            char[] ResultXor_b2 = functionXor(ER2, claves.getK3());
            String F_SB_2 = Get_Claves_B(ResultXor_b2);
            char[] F3 = ObejetoDePermutacion.PermutedP(F_SB_2);
            char[] ResultXor_a3 = functionXor(F3, Datito.getL2());
            Datito.setR3(ResultXor_a3);
            Datito.setL3(Datito.getR2());
            char[] ER3 = ObejetoDePermutacion.PermutedExpancion(Datito.getR3());
            char[] ResultXor_b4 = functionXor(ER3, claves.getK4());
            String F_SB_3 = Get_Claves_B(ResultXor_b4);

            char[] F4 = ObejetoDePermutacion.PermutedP(F_SB_3);
            char[] ResultXor_a5 = functionXor(F4, Datito.getL3());
            Datito.setR4(ResultXor_a5);
            Datito.setL4(Datito.getR3());
            char[] ER4 = ObejetoDePermutacion.PermutedExpancion(Datito.getR4());
            char[] ResultXor_b5 = functionXor(ER4, claves.getK5());
            String F_SB_4 = Get_Claves_B(ResultXor_b5);

            char[] F5 = ObejetoDePermutacion.PermutedP(F_SB_4);
            char[] ResultXor_a6 = functionXor(F5, Datito.getL4());
            Datito.setR5(ResultXor_a6);
            Datito.setL5(Datito.getR4());
            char[] ER5 = ObejetoDePermutacion.PermutedExpancion(Datito.getR5());
            char[] ResultXor_b6 = functionXor(ER5, claves.getK6());
            String F_SB_5 = Get_Claves_B(ResultXor_b6);

            char[] F6 = ObejetoDePermutacion.PermutedP(F_SB_5);
            char[] ResultXor_a7 = functionXor(F6, Datito.getL5());
            Datito.setR6(ResultXor_a7);
            Datito.setL6(Datito.getR5());
            char[] ER6 = ObejetoDePermutacion.PermutedExpancion(Datito.getR6());
            char[] ResultXor_b7 = functionXor(ER6, claves.getK7());
            String F_SB_6 = Get_Claves_B(ResultXor_b7);

            char[] F7 = ObejetoDePermutacion.PermutedP(F_SB_6);
            char[] ResultXor_a8 = functionXor(F7, Datito.getL6());
            Datito.setR7(ResultXor_a8);
            Datito.setL7(Datito.getR6());
            char[] ER7 = ObejetoDePermutacion.PermutedExpancion(Datito.getR7());
            char[] ResultXor_b8 = functionXor(ER7, claves.getK8());
            String F_SB_7 = Get_Claves_B(ResultXor_b8);

            char[] F8 = ObejetoDePermutacion.PermutedP(F_SB_7);
            char[] ResultXor_a9 = functionXor(F8, Datito.getL7());
            Datito.setR8(ResultXor_a9);
            Datito.setL8(Datito.getR7());
            char[] ER8 = ObejetoDePermutacion.PermutedExpancion(Datito.getR8());
            char[] ResultXor_b9 = functionXor(ER8, claves.getK9());
            String F_SB_8 = Get_Claves_B(ResultXor_b9);

            char[] F9 = ObejetoDePermutacion.PermutedP(F_SB_8);
            char[] ResultXor_a10 = functionXor(F9, Datito.getL8());
            Datito.setR9(ResultXor_a10);
            Datito.setL9(Datito.getR8());
            char[] ER9 = ObejetoDePermutacion.PermutedExpancion(Datito.getR9());
            char[] ResultXor_b10 = functionXor(ER9, claves.getK10());
            String F_SB_9 = Get_Claves_B(ResultXor_b10);

            char[] F10 = ObejetoDePermutacion.PermutedP(F_SB_9);
            char[] ResultXor_a11 = functionXor(F10, Datito.getL9());
            Datito.setR10(ResultXor_a11);
            Datito.setL10(Datito.getR9());
            char[] ER10 = ObejetoDePermutacion.PermutedExpancion(Datito.getR10());
            char[] ResultXor_b11 = functionXor(ER10, claves.getK11());
            String F_SB_10 = Get_Claves_B(ResultXor_b11);

            char[] F11 = ObejetoDePermutacion.PermutedP(F_SB_10);
            char[] ResultXor_a12 = functionXor(F11, Datito.getL10());
            Datito.setR11(ResultXor_a12);
            Datito.setL11(Datito.getR10());
            char[] ER11 = ObejetoDePermutacion.PermutedExpancion(Datito.getR11());
            char[] ResultXor_b12 = functionXor(ER11, claves.getK12());
            String F_SB_11 = Get_Claves_B(ResultXor_b12);

            char[] F12 = ObejetoDePermutacion.PermutedP(F_SB_11);
            char[] ResultXor_a13 = functionXor(F12, Datito.getL11());
            Datito.setR12(ResultXor_a13);
            Datito.setL12(Datito.getR11());
            char[] ER12 = ObejetoDePermutacion.PermutedExpancion(Datito.getR12());
            char[] ResultXor_b13 = functionXor(ER12, claves.getK13());
            String F_SB_12 = Get_Claves_B(ResultXor_b13);

            char[] F13 = ObejetoDePermutacion.PermutedP(F_SB_12);
            char[] ResultXor_a14 = functionXor(F13, Datito.getL12());
            Datito.setR13(ResultXor_a14);
            Datito.setL13(Datito.getR12());
            char[] ER13 = ObejetoDePermutacion.PermutedExpancion(Datito.getR13());
            char[] ResultXor_b14 = functionXor(ER13, claves.getK14());
            String F_SB_13 = Get_Claves_B(ResultXor_b14);

            char[] F14 = ObejetoDePermutacion.PermutedP(F_SB_13);
            char[] ResultXor_a15 = functionXor(F14, Datito.getL13());
            Datito.setR14(ResultXor_a15);
            Datito.setL14(Datito.getR13());
            char[] ER14 = ObejetoDePermutacion.PermutedExpancion(Datito.getR14());
            char[] ResultXor_b15 = functionXor(ER14, claves.getK15());
            String F_SB_14 = Get_Claves_B(ResultXor_b15);

            char[] F15 = ObejetoDePermutacion.PermutedP(F_SB_14);
            char[] ResultXor_a16 = functionXor(F15, Datito.getL14());
            Datito.setR15(ResultXor_a16);
            Datito.setL15(Datito.getR14());
            char[] ER15 = ObejetoDePermutacion.PermutedExpancion(Datito.getR15());
            char[] ResultXor_b16 = functionXor(ER15, claves.getK16());
            String F_SB_15 = Get_Claves_B(ResultXor_b16);

            char[] F16 = ObejetoDePermutacion.PermutedP(F_SB_15);
            char[] ResultXor_a17 = functionXor(F16, Datito.getL15());
            Datito.setR16(ResultXor_a17);
            Datito.setL16(Datito.getR15());

            char[] concatenacionFinal = new char[64];
            for (int i = 0; i < 32; ++i) {
                concatenacionFinal[i] = Datito.getR16()[i];
                concatenacionFinal[i + 32] = Datito.getL16()[i];
            }
            char[] FinalPermutation = ObejetoDePermutacion.PermutedFinal(concatenacionFinal);

            Conversor64bits Convert = new Conversor64bits();
            String obj = Convert.ConvertBinToHexa(FinalPermutation);

            return obj;
        } catch (Exception e) {
            return "Error al procesar el dato, Error: " + e.getLocalizedMessage();
        }
    }

    public String ProcesoDeDatoDescifrar(String datoHexa, ObjetoClaves claves) {
        try {
            Conversor64bits Binario = new Conversor64bits();
            DatoBin = Binario.ConvertToBin(datoHexa);

            CajaDePermutacion ObejetoDePermutacion = new CajaDePermutacion();
            char[] num = ObejetoDePermutacion.PermutedIP(DatoBin);
            char[] L = new char[32];
            char[] R = new char[32];
            for (int i = 0; i < 32; ++i) {
                L[i] = num[i];
                R[i] = num[i + 32];
            }
            ObjetoDatos Datito = new ObjetoDatos();
            Datito.setL0(L);
            Datito.setR0(R);
            char[] ER = ObejetoDePermutacion.PermutedExpancion(Datito.getR0());
            char[] k16 = claves.getK16();
            char[] ResultXor0 = functionXor(ER, k16);
            String F_SB_0 = Get_Claves_B(ResultXor0);

            char[] F1 = ObejetoDePermutacion.PermutedP(F_SB_0);
            char[] ResultXor_a1 = functionXor(F1, Datito.getL0());
            Datito.setR1(ResultXor_a1);
            Datito.setL1(Datito.getR0());
            char[] ER1 = ObejetoDePermutacion.PermutedExpancion(Datito.getR1());
            char[] ResultXor_b1 = functionXor(ER1, claves.getK15());
            String F_SB_1 = Get_Claves_B(ResultXor_b1);

            char[] F2 = ObejetoDePermutacion.PermutedP(F_SB_1);
            char[] ResultXor_a2 = functionXor(F2, Datito.getL1());
            Datito.setR2(ResultXor_a2);
            Datito.setL2(Datito.getR1());
            char[] ER2 = ObejetoDePermutacion.PermutedExpancion(Datito.getR2());
            char[] ResultXor_b2 = functionXor(ER2, claves.getK14());
            String F_SB_2 = Get_Claves_B(ResultXor_b2);
            char[] F3 = ObejetoDePermutacion.PermutedP(F_SB_2);
            char[] ResultXor_a3 = functionXor(F3, Datito.getL2());
            Datito.setR3(ResultXor_a3);
            Datito.setL3(Datito.getR2());
            char[] ER3 = ObejetoDePermutacion.PermutedExpancion(Datito.getR3());
            char[] ResultXor_b4 = functionXor(ER3, claves.getK13());
            String F_SB_3 = Get_Claves_B(ResultXor_b4);

            char[] F4 = ObejetoDePermutacion.PermutedP(F_SB_3);
            char[] ResultXor_a5 = functionXor(F4, Datito.getL3());
            Datito.setR4(ResultXor_a5);
            Datito.setL4(Datito.getR3());
            char[] ER4 = ObejetoDePermutacion.PermutedExpancion(Datito.getR4());
            char[] ResultXor_b5 = functionXor(ER4, claves.getK12());
            String F_SB_4 = Get_Claves_B(ResultXor_b5);

            char[] F5 = ObejetoDePermutacion.PermutedP(F_SB_4);
            char[] ResultXor_a6 = functionXor(F5, Datito.getL4());
            Datito.setR5(ResultXor_a6);
            Datito.setL5(Datito.getR4());
            char[] ER5 = ObejetoDePermutacion.PermutedExpancion(Datito.getR5());
            char[] ResultXor_b6 = functionXor(ER5, claves.getK11());
            String F_SB_5 = Get_Claves_B(ResultXor_b6);

            char[] F6 = ObejetoDePermutacion.PermutedP(F_SB_5);
            char[] ResultXor_a7 = functionXor(F6, Datito.getL5());
            Datito.setR6(ResultXor_a7);
            Datito.setL6(Datito.getR5());
            char[] ER6 = ObejetoDePermutacion.PermutedExpancion(Datito.getR6());
            char[] ResultXor_b7 = functionXor(ER6, claves.getK10());
            String F_SB_6 = Get_Claves_B(ResultXor_b7);

            char[] F7 = ObejetoDePermutacion.PermutedP(F_SB_6);
            char[] ResultXor_a8 = functionXor(F7, Datito.getL6());
            Datito.setR7(ResultXor_a8);
            Datito.setL7(Datito.getR6());
            char[] ER7 = ObejetoDePermutacion.PermutedExpancion(Datito.getR7());
            char[] ResultXor_b8 = functionXor(ER7, claves.getK9());
            String F_SB_7 = Get_Claves_B(ResultXor_b8);

            char[] F8 = ObejetoDePermutacion.PermutedP(F_SB_7);
            char[] ResultXor_a9 = functionXor(F8, Datito.getL7());
            Datito.setR8(ResultXor_a9);
            Datito.setL8(Datito.getR7());
            char[] ER8 = ObejetoDePermutacion.PermutedExpancion(Datito.getR8());
            char[] ResultXor_b9 = functionXor(ER8, claves.getK8());
            String F_SB_8 = Get_Claves_B(ResultXor_b9);

            char[] F9 = ObejetoDePermutacion.PermutedP(F_SB_8);
            char[] ResultXor_a10 = functionXor(F9, Datito.getL8());
            Datito.setR9(ResultXor_a10);
            Datito.setL9(Datito.getR8());
            char[] ER9 = ObejetoDePermutacion.PermutedExpancion(Datito.getR9());
            char[] ResultXor_b10 = functionXor(ER9, claves.getK7());
            String F_SB_9 = Get_Claves_B(ResultXor_b10);

            char[] F10 = ObejetoDePermutacion.PermutedP(F_SB_9);
            char[] ResultXor_a11 = functionXor(F10, Datito.getL9());
            Datito.setR10(ResultXor_a11);
            Datito.setL10(Datito.getR9());
            char[] ER10 = ObejetoDePermutacion.PermutedExpancion(Datito.getR10());
            char[] ResultXor_b11 = functionXor(ER10, claves.getK6());
            String F_SB_10 = Get_Claves_B(ResultXor_b11);

            char[] F11 = ObejetoDePermutacion.PermutedP(F_SB_10);
            char[] ResultXor_a12 = functionXor(F11, Datito.getL10());
            Datito.setR11(ResultXor_a12);
            Datito.setL11(Datito.getR10());
            char[] ER11 = ObejetoDePermutacion.PermutedExpancion(Datito.getR11());
            char[] ResultXor_b12 = functionXor(ER11, claves.getK5());
            String F_SB_11 = Get_Claves_B(ResultXor_b12);

            char[] F12 = ObejetoDePermutacion.PermutedP(F_SB_11);
            char[] ResultXor_a13 = functionXor(F12, Datito.getL11());
            Datito.setR12(ResultXor_a13);
            Datito.setL12(Datito.getR11());
            char[] ER12 = ObejetoDePermutacion.PermutedExpancion(Datito.getR12());
            char[] ResultXor_b13 = functionXor(ER12, claves.getK4());
            String F_SB_12 = Get_Claves_B(ResultXor_b13);

            char[] F13 = ObejetoDePermutacion.PermutedP(F_SB_12);
            char[] ResultXor_a14 = functionXor(F13, Datito.getL12());
            Datito.setR13(ResultXor_a14);
            Datito.setL13(Datito.getR12());
            char[] ER13 = ObejetoDePermutacion.PermutedExpancion(Datito.getR13());
            char[] ResultXor_b14 = functionXor(ER13, claves.getK3());
            String F_SB_13 = Get_Claves_B(ResultXor_b14);

            char[] F14 = ObejetoDePermutacion.PermutedP(F_SB_13);
            char[] ResultXor_a15 = functionXor(F14, Datito.getL13());
            Datito.setR14(ResultXor_a15);
            Datito.setL14(Datito.getR13());
            char[] ER14 = ObejetoDePermutacion.PermutedExpancion(Datito.getR14());
            char[] ResultXor_b15 = functionXor(ER14, claves.getK2());
            String F_SB_14 = Get_Claves_B(ResultXor_b15);

            char[] F15 = ObejetoDePermutacion.PermutedP(F_SB_14);
            char[] ResultXor_a16 = functionXor(F15, Datito.getL14());
            Datito.setR15(ResultXor_a16);
            Datito.setL15(Datito.getR14());
            char[] ER15 = ObejetoDePermutacion.PermutedExpancion(Datito.getR15());
            char[] ResultXor_b16 = functionXor(ER15, claves.getK1());
            String F_SB_15 = Get_Claves_B(ResultXor_b16);

            char[] F16 = ObejetoDePermutacion.PermutedP(F_SB_15);
            char[] ResultXor_a17 = functionXor(F16, Datito.getL15());
            Datito.setR16(ResultXor_a17);
            Datito.setL16(Datito.getR15());

            char[] concatenacionFinal = new char[64];
            for (int i = 0; i < 32; ++i) {
                concatenacionFinal[i] = Datito.getR16()[i];
                concatenacionFinal[i + 32] = Datito.getL16()[i];
            }
            char[] FinalPermutation = ObejetoDePermutacion.PermutedFinal(concatenacionFinal);

            Conversor64bits Convert = new Conversor64bits();
            String obj = Convert.ConvertBinToHexa(FinalPermutation);

            return obj;
        } catch (Exception e) {
            return "Error al procesar el dato, Error: " + e.getLocalizedMessage();
        }
    }

    public char[] StringToChar(String Cadenita) {
        int tamañoCadena = Cadenita.length();
        char[] ArregloCadena = new char[tamañoCadena];
        for (int i = 0; i < tamañoCadena; ++i) {
            ArregloCadena[i] = Cadenita.charAt(i);
        }
        return ArregloCadena;
    }

    public String Get_Claves_B(char[] BinOriginal) {
        char[] B1 = new char[6];
        char[] B2 = new char[6];
        char[] B3 = new char[6];
        char[] B4 = new char[6];
        char[] B5 = new char[6];
        char[] B6 = new char[6];
        char[] B7 = new char[6];
        char[] B8 = new char[6];
        for (int i = 0; i < 6; ++i) {
            B1[i] = BinOriginal[i];
            B2[i] = BinOriginal[i + 6];
            B3[i] = BinOriginal[i + 12];
            B4[i] = BinOriginal[i + 18];
            B5[i] = BinOriginal[i + 24];
            B6[i] = BinOriginal[i + 30];
            B7[i] = BinOriginal[i + 36];
            B8[i] = BinOriginal[i + 42];
        }

        String F_SB = "";
        F_SB = F_SB + Get_MB_AND_NB(B1, 1);
        F_SB = F_SB + Get_MB_AND_NB(B2, 2);
        F_SB = F_SB + Get_MB_AND_NB(B3, 3);
        F_SB = F_SB + Get_MB_AND_NB(B4, 4);
        F_SB = F_SB + Get_MB_AND_NB(B5, 5);
        F_SB = F_SB + Get_MB_AND_NB(B6, 6);
        F_SB = F_SB + Get_MB_AND_NB(B7, 7);
        F_SB = F_SB + Get_MB_AND_NB(B8, 8);
        return F_SB;
    }

    public String Get_MB_AND_NB(char[] Bi, int S_Number) {
        char[] MB = new char[2];
        char[] NB = new char[4];
        MB[0] = Bi[0];
        NB[0] = Bi[1];
        NB[1] = Bi[2];
        NB[2] = Bi[3];
        NB[3] = Bi[4];
        MB[1] = Bi[5];
        int fila = StringToBinary(CharToString(MB));
        int columna = StringToBinary(CharToString(NB));

        CajaS ObjetoDePermutacion = new CajaS();
        int num = ObjetoDePermutacion.CajaS(S_Number, fila, columna);
        Conversor64bits Convert = new Conversor64bits();
        String NumBin = Convert.BinarizarCifrasDosDigitos(num);
        return NumBin;
    }

    public String CharToString(char[] arreglo) {
        int num = arreglo.length;
        String Cadenita = "";
        for (int i = 0; i < num; ++i) {
            Cadenita = Cadenita + arreglo[i];
        }
        return Cadenita;
    }

    public int StringToBinary(String numeroBinario) {
        int num = Integer.parseInt(numeroBinario, 2);
        return num;
    }

    public char[] functionXor(char[] E, char[] K) {
        int tamaño = E.length;
        char[] ResultXor = new char[tamaño];

        for (int i = 0; i < tamaño; ++i) {
            if ((E[i] == K[i])) {
                ResultXor[i] = '0';
            } else {
                ResultXor[i] = '1';
            }
        }
        return ResultXor;
    }

    public ObjetoClaves ProcesoDeClave(String claveHexa) {
        try {
            Conversor64bits Binario = new Conversor64bits();
            ClaveBin = Binario.ConvertToBin(claveHexa);

            CajaDePermutacion ObejetoDePermutacion = new CajaDePermutacion();
            char[] num = ObejetoDePermutacion.PermutedChoice1(ClaveBin);
            char[] C = new char[28];
            char[] D = new char[28];

            for (int i = 0; i < 28; ++i) {
                C[i] = num[i];
                D[i] = num[i + 28];
            }

            ObjetoClaves DatosGenerado = GeneradorDe_CyD(C, D);
            try {
                DatosGenerado.setK1(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC1(), DatosGenerado.getD1())));
                DatosGenerado.setK2(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC2(), DatosGenerado.getD2())));
                DatosGenerado.setK3(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC3(), DatosGenerado.getD3())));
                DatosGenerado.setK4(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC4(), DatosGenerado.getD4())));
                DatosGenerado.setK5(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC5(), DatosGenerado.getD5())));
                DatosGenerado.setK6(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC6(), DatosGenerado.getD6())));
                DatosGenerado.setK7(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC7(), DatosGenerado.getD7())));
                DatosGenerado.setK8(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC8(), DatosGenerado.getD8())));
                DatosGenerado.setK9(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC9(), DatosGenerado.getD9())));
                DatosGenerado.setK10(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC10(), DatosGenerado.getD10())));
                DatosGenerado.setK11(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC11(), DatosGenerado.getD11())));
                DatosGenerado.setK12(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC12(), DatosGenerado.getD12())));
                DatosGenerado.setK13(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC13(), DatosGenerado.getD13())));
                DatosGenerado.setK14(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC14(), DatosGenerado.getD14())));
                DatosGenerado.setK15(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC15(), DatosGenerado.getD15())));
                DatosGenerado.setK16(ObejetoDePermutacion.PermutedChoice2(ConcatenadorDe_CyD_56bits(DatosGenerado.getC16(), DatosGenerado.getD16())));
            } catch (Exception e) {
                System.out.println("Error :v =" + e.getLocalizedMessage());
            }
            return DatosGenerado;
        } catch (Exception e) {
            return null;
        }
    }

    public char[] ConcatenadorDe_CyD_56bits(char[] C, char[] D) {
        char[] concatenacion = new char[56];
        for (int i = 0; i < 28; ++i) {
            concatenacion[i] = C[i];
            concatenacion[i + 28] = D[i];
        }
        return concatenacion;
    }

    public ObjetoClaves GeneradorDe_CyD(char[] C0, char[] D0) {
        //Para las C
        char[] C1 = Recorrer1(C0);
        char[] C2 = Recorrer1(C1);
        char[] C3 = Recorrer2(C2);
        char[] C4 = Recorrer2(C3);
        char[] C5 = Recorrer2(C4);
        char[] C6 = Recorrer2(C5);
        char[] C7 = Recorrer2(C6);
        char[] C8 = Recorrer2(C7);
        char[] C9 = Recorrer1(C8);
        char[] C10 = Recorrer2(C9);
        char[] C11 = Recorrer2(C10);
        char[] C12 = Recorrer2(C11);
        char[] C13 = Recorrer2(C12);
        char[] C14 = Recorrer2(C13);
        char[] C15 = Recorrer2(C14);
        char[] C16 = Recorrer1(C15);

        //Para las D
        char[] D1 = Recorrer1(D0);
        char[] D2 = Recorrer1(D1);
        char[] D3 = Recorrer2(D2);
        char[] D4 = Recorrer2(D3);
        char[] D5 = Recorrer2(D4);
        char[] D6 = Recorrer2(D5);
        char[] D7 = Recorrer2(D6);
        char[] D8 = Recorrer2(D7);
        char[] D9 = Recorrer1(D8);
        char[] D10 = Recorrer2(D9);
        char[] D11 = Recorrer2(D10);
        char[] D12 = Recorrer2(D11);
        char[] D13 = Recorrer2(D12);
        char[] D14 = Recorrer2(D13);
        char[] D15 = Recorrer2(D14);
        char[] D16 = Recorrer1(D15);
        //Creacion del dato
        ObjetoClaves Datitos = new ObjetoClaves();
        //Asignacion de las C
        Datitos.setC0(C0);
        Datitos.setC1(C1);
        Datitos.setC2(C2);
        Datitos.setC3(C3);
        Datitos.setC4(C4);
        Datitos.setC5(C5);
        Datitos.setC6(C6);
        Datitos.setC7(C7);
        Datitos.setC8(C8);
        Datitos.setC9(C9);
        Datitos.setC10(C10);
        Datitos.setC11(C11);
        Datitos.setC12(C12);
        Datitos.setC13(C13);
        Datitos.setC14(C14);
        Datitos.setC15(C15);
        Datitos.setC16(C16);
        //Asignacion de las D
        Datitos.setD0(D0);
        Datitos.setD1(D1);
        Datitos.setD2(D2);
        Datitos.setD3(D3);
        Datitos.setD4(D4);
        Datitos.setD5(D5);
        Datitos.setD6(D6);
        Datitos.setD7(D7);
        Datitos.setD8(D8);
        Datitos.setD9(D9);
        Datitos.setD10(D10);
        Datitos.setD11(D11);
        Datitos.setD12(D12);
        Datitos.setD13(D13);
        Datitos.setD14(D14);
        Datitos.setD15(D15);
        Datitos.setD16(D16);
        return Datitos;
    }

    public char[] Recorrer1(char[] NumeroOriginal) {
        char[] NumRecorrido = new char[28];
        for (int i = 0; i < 27; ++i) {
            NumRecorrido[i] = NumeroOriginal[i + 1];
        }
        NumRecorrido[27] = NumeroOriginal[0];
        return NumRecorrido;
    }

    public char[] Recorrer2(char[] NumeroOriginal) {
        char[] NumRecorrido = new char[28];
        for (int i = 0; i < 26; ++i) {
            NumRecorrido[i] = NumeroOriginal[i + 2];
        }
        NumRecorrido[26] = NumeroOriginal[0];
        NumRecorrido[27] = NumeroOriginal[1];
        return NumRecorrido;
    }

}
