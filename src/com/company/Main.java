package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;
        int option = 0;
        Radio radio = new RadioController();

        while (!exit) {
            System.out.println("Ingrese el número de la opción que desea realizar." + ((!radio.isOn()) ?
                    "\n1. Encender\n2. Finalizar simulación" : "\n1. Siguiente emisora\n2. Emisora anterior" +
                    "\n3. Cambiar frecuencia\n4. Guardar emisora como favorita\n5. Obtener emisora favorita\n6. Finalizar simulación"));
            option = Integer.parseInt(getNumber(keyboard));

            if (!radio.isOn() && (option < 1 || option > 2)) {
                System.out.println("La opción ingresadad no está definida.");
                continue;
            }

            switch (option) {
                case 1:
                    if (!radio.isOn()) radio.turnOnOff();
                    else radio.nextStation(radio.getFrequency());
                    break;
                case 2:
                    if (!radio.isOn()) exit = true;

                    radio.prevStation(radio.getFrequency());
                    break;
                case 3:
                    radio.switchAMFM();
                case 4:
                    int position = Integer.parseInt(getNumber(keyboard));
                    radio.saveStation(position, radio.getStation());
                case 5:
                    int position1 = Integer.parseInt(getNumber(keyboard));
                    radio.getSavedStation(position1);
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("La opción ingresadad no está definida.");
            }
        }
    }

    /**
     * @param keyboard
     * @return
     */
    private static String getNumber(Scanner keyboard) {
        String number = keyboard.nextLine();
        boolean isNumber = false;

        while (!isNumber) {
            try {
                int nm = Integer.parseInt(number);
                isNumber = true;
            } catch (NumberFormatException nft) {
                System.out.println("ERROR. Verifique que el valor ingresado sea numérico e intente de nuevo.");
                number = keyboard.nextLine();
            }
        }

        return number;
    }
}