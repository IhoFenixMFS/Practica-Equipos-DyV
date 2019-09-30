package equipos.dyv;

public class EquiposDyV {

    public static void main(String[] args) {
        int maxEqSem = 2;
        boolean descanso = false, rellenar = false;
        int n = 3;
        int aux = 1, aux2;
        String txtaux = "";
        String[][] par = new String[maxEqSem][maxEqSem];
        /*while (!desc){ mientras desc sea falso
        generar un math.random de 0 a 4=aux2
        for(int j=0, j<=semanas;j++){
        par[i,aux2]='descanso';
        i++;
         */
        for (int filaEq = 0; filaEq < maxEqSem; filaEq++) {
            for (int columnaSem = 0; columnaSem < maxEqSem; columnaSem++) {
                /*Si esa semana no juega contra nadie aun*/
                if (par[filaEq][columnaSem] == null) {
                    while (!rellenar) {
                        if (aux == 6) {
                            /*Si vamos a asignarle un descanso, antes comprobaremos
                            que nadie más descanse esa semana*/
                            for (int k = 0; k < maxEqSem; k++) {
                                if (par[k][columnaSem].equals("Descanso")) {
                                    descanso = true;
                                }
                            }
                            if (descanso) {
                                aux = 1;
                            } else {
                                par[filaEq][columnaSem] = "Descanso";
                                rellenar = true;
                            }
                        }
                        /*Si no hemos rellenado nada
                        Es decir, si aux era 6 pero ya se descansaba esa semana,
                        o si aux no era 6*/
                        if (!rellenar) {
                            /*Comprobamos que */
                            for (int k = 0; k < maxEqSem; k++) {
                                /*si ya hay un partido/descanso asignado en esa fila,
                            almacenamos el número para comprobar si es el del equipo
                            que queremos incluir*/
                                System.out.println(par[filaEq][k]);
                                if (par[filaEq][k] == null) {
                                    System.out.println(par[filaEq][k]);
                                } else {
                                    /*aux2 recibe el valor del equipo asignado esa semana o
                                un 6 si es descanso*/
                                    System.out.println(par[filaEq][columnaSem]);
                                    if (!(par[filaEq][k] == "Descanso")) {
                                        txtaux = par[filaEq][k];
                                        aux2 = (int) txtaux.charAt(txtaux.length() - 1);
                                    } else {
                                        aux2 = 6;
                                    }
                                    /*Comprobamos que el Eq que queremos incluir no sea uno que ya está asignado,
                                    en ese caso se actualiza el valor de aux*/
                                    if (aux == aux2) {
                                        /*Si aux ya vale 6 (que es el descanso, se reinicia;
                                        Si no, pasa al equipo siguiente*/
                                        if (aux == n) {
                                            aux = 1;
                                        } else {
                                            aux = aux + 1;
                                        }/*pasamos al siguiente valor de aux*/
                                    }
                                }/*Si no está vacío ese hueco*/
                            }/*for comprobar fila (si hay partidos asignados a ese equipo.*/

 /*Si aux no es 6 el cual corresponde a un descanso, le decimos que el eq(filaEq)
                            juegue contra el equipo aux*/
                            par[filaEq][columnaSem] = ("Eq" + aux);
                            rellenar=true;
                            descanso = false;
                        }

                    }/*fin del while rellenar*/
                }/*fin del if está vacío*/
 /*reseteamos la variable de rellenar*/
                rellenar = false;
            }/*for columnaSem  */
        }/*for filaEq*/
 /*mostrar*/
        for (int i = 0; i < maxEqSem; i++) {
            for (int j = 0; j < maxEqSem; j++) {
                System.out.print(par[i][j]);
                System.err.print(" | ");
            }
            System.out.println(".");
        }
    }
    /*fin del main*/
}
