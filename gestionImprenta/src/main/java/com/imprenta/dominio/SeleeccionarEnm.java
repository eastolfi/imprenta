package com.imprenta.dominio;

import java.util.Scanner;

public class SeleeccionarEnm {

    public static TamanioPapel SeleccionarTamanioPapel() {
        int opcion;
        Scanner menu = new Scanner(System.in);
        //TamanioPapel formato = null;
        while (true) {
            System.out.println("---------------------------------------------\n"
                + "           SELECCIONE FORMATO"
                + "\n---------------------------------------------\n"
                    + "1. - A3\n"
                    + "2. - A4\n"
                    + "3. - A5\n"
                    + "4. - A6\n"
                    + "5. - Tarjeta visita (85x55)\n"
            );
            opcion = menu.nextInt();
            switch (opcion) {
                case 1:
                    return TamanioPapel.A3;
                case 2:
                    return TamanioPapel.A4;
                case 3:
                    return TamanioPapel.A5;
                case 4:
                    return TamanioPapel.A6;
                case 5:
                    return TamanioPapel.TARJETA;
                case 0:
                    System.out.println("Volver");
                    return null;
            }
            //return null;
        }
    }

    public static TipoPapel SeleccionarTipoPapel() {
        int opcion;
        Scanner menu = new Scanner(System.in);
        //TipoPapel papel = null;
        while (true) {
            System.out.println("----------------------------------\n"
                + "           TIPO DE PAPEL"
                + "\n----------------------------------\n"
                    + "1. - BRILLO\n"
                    + "2. - MATE\n"
                    + "3. - OFFSET\n"
                    + "4. - CARTULINA\n"
                    + "5. - VERJURADO\n"
                    + "6. - RECICLADO"
            );
            opcion = menu.nextInt();
            switch (opcion) {
                case 1:
                    return TipoPapel.BRILLO;
                case 2:
                    return TipoPapel.MATE;
                case 3:
                    return TipoPapel.OFFSET;
                case 4:
                    return TipoPapel.CARTULINA;
                case 5:
                    return TipoPapel.VERJURADO;
                case 6:
                    return TipoPapel.RECICLADO;
                case 0:
                    System.out.println("Volver");
                    return null;
            }
        }
    }

    
    public static TipoPlastificado SeleccionarPlastificado() {
        int opcion;
        Scanner menu = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------------\n"
                + "           PLASTIFICADO"
                + "\n----------------------------------\n"
                    + "1. - BRILLO\n"
                    + "2. - MATE\n"
                    + "3. - SEDOSO\n"
                    + "4. - ANTIRAYAS\n"
                    + "5. - NO LLEVA\n"
            );
            opcion = menu.nextInt();
            switch (opcion) {
                case 1:
                    return TipoPlastificado.BRILLO;
                case 2:
                    return TipoPlastificado.MATE;
                case 3:
                    return TipoPlastificado.SEDOSO;
                case 4:
                    return TipoPlastificado.ANTIRAYAS;
                case 5:
                    return TipoPlastificado.NO;
                case 0:
                    System.out.println("Volver");
                    return null;
            }
            //return null;
        }
    }

    

        public static TipoEncuadernado SeleccionarEncuadernado() {
            int opcion;
            Scanner menu = new Scanner(System.in);
            while (true) {
                System.out.println("----------------------------------\n"
                + "           ENCUADERNADO"
                + "\n----------------------------------\n"
                        + "1. - WIRE-O\n"
                        + "2. - ESPIRAL\n"
                        + "3. - PUR\n"
                        + "4. - GRAPA\n"
                        + "5. - NO LLEVA\n"
                );
                opcion = menu.nextInt();
                switch (opcion) {
                    case 1:
                        return TipoEncuadernado.WIREO;
                    case 2:
                        return TipoEncuadernado.ESPIRAL;
                    case 3:
                        return TipoEncuadernado.PUR;
                    case 4:
                        return TipoEncuadernado.GRAPA;
                    case 5:
                        return TipoEncuadernado.NO;
                   
                    case 0:
                        System.out.println("Volver");
                        return null;
                }
                //return null;
            }
        }

    }
