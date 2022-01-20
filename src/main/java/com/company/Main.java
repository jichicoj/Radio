package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in); // Variable que obtiene le input
        boolean exit = false; // Variable de control para salir del menú
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
            // Menú
            switch (option) {
                case 1:
                    if (!radio.isOn()) radio.turnOnOff();
                    else radio.nextStation(radio.getFrequency());

                    System.out.println(printState(radio));
                    break;
                case 2:
                    if (!radio.isOn()) exit = true;
                    else {
                        radio.prevStation(radio.getFrequency());
                        System.out.println(printState(radio));
                    }
                    break;
                case 3:
                    radio.switchAMFM();
                    System.out.println(printState(radio));
                    break;
                case 4:
                    System.out.println("Ingrese el número de la posición en la que desea guardar la emisora");
                    int position = Integer.parseInt(getNumber(keyboard));

                    if (position > 12 || position < 0) {
                        System.out.println("No existe la posición ingresada. Elija un número entre 1 y 12");
                    }

                    radio.saveStation(position, radio.getStation());
                    System.out.println(printState(radio));
                    break;
                case 5:
                    System.out.println("Ingrese el número de la posición en la que se encuentra la emisora");
                    int position1 = Integer.parseInt(getNumber(keyboard));

                    if (position1 > 12 || position1 < 0) {
                        System.out.println("No existe la posición que intenta llenar. Elija un número entre 1 y 12");
                    }

                    double savedStation = radio.getSavedStation(position1);

                    if (savedStation == 0) {
                        System.out.println("No hay ninguna estación almacenada en esta posición");
                    }

                    System.out.println(printState(radio));
                    break;
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
        String number = keyboard.nextLine(); // Obtiene el input
        boolean isNumber = false;

        while (!isNumber) { // Vuelve a pedir input hasta que este sea un número
            try {
                int nm = Integer.parseInt(number); // Verifica que el input sea un número
                isNumber = true;
            } catch (NumberFormatException nft) {
                System.out.println("ERROR. Verifique que el valor ingresado sea numérico e intente de nuevo.");
                number = keyboard.nextLine();
            }
        }

        return number;
    }

    /**
     * @param radio
     * @return
     */
    private static String printState(Radio radio) { // Crea una string con el estado del radio
        String station = String.format("%.02f", radio.getStation());
        String frequency = (radio.getFrequency()) ? "AM" : "FM";
        return frequency + "\n\t\t\tEscuchando ahora\n\n\t\t\t\t  " + station + "\n\t\t\t\t←  ►  →";
    }
}