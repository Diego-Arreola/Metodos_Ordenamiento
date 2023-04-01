import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SortsDAO {
    private String[] datos;
    private DoublyLinkedList<Pelicula> listaPeliculas;
    private DoublyLink<Pelicula> current;
    private long tiempoDeEjecucion;
    private int Intercambios;
    private int Comparaciones;
    private ArrayList<metricas> metricas;
    private Scanner scanner = new Scanner(System.in);
    private boolean disableRadix = false;
    private int atributoComp;
    private int atributoOrden;

    /**
     * Este método lee un CSV, separa y guarda su información en una lista
     * Utiliza un arreglo para separar la información guardar en una variable de tipo Pelicula
     * Esa variable de tipo Pelicula se agrega a la lista como un nodo
     * @param filePath
     * @throws IOException
     */
    public void readCSV(String filePath)throws IOException{
        String Separador = ",";
        BufferedReader bufferLectura = null;
        listaPeliculas = new DoublyLinkedList<>();
        Pelicula pelicula;
        String dura;
        metricas = new ArrayList<>();
        try{
            bufferLectura = new BufferedReader(new FileReader(filePath));
            String linea = bufferLectura.readLine();
        
            while (linea != null){
                datos = linea.split(Separador);
                dura = Separar(datos[4]);
                pelicula = new Pelicula(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]), Float.parseFloat(datos[3]), Integer.parseInt(dura));
                listaPeliculas.insertFirst(pelicula);
                
                linea = bufferLectura.readLine();
            } 
            
            menu();
           
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally {
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }

    /**
     * Este método separar la duracion de la pelicula
     * Elimina los caracteres y deja solo los digitos
     * @param string
     * @return dura2
     */
    public String Separar(String string){
        String[] parts = string.split("h");
        String[] string2 = parts[1].split("m");
        String dura1 = parts[0] + string2[0];
        String dura2 = Convertir(dura1);
        return dura2;
    }

    /**
     * Este método convierte la duracion de la pelicula en minutos
     * @param string
     * @return dura
     */
    public String Convertir(String string){
        String[] duracion = string.split(" ");
        int minutos = Integer.parseInt(duracion[0]) * 60 + Integer.parseInt(duracion[1]);
        String dura = String.valueOf(minutos);
        return dura;
    }

    /**
     * Este método guarda el atributo base dado por el usuario
     * El atributo se utilizara para hacer el ordenamiento
     * 
     * @return option
     */
    public int elegirOpcionAtributo(){
        System.out.println("\n1. Puntuacion");
        System.out.println("2. Nombre");
        System.out.println("3. Año");
        System.out.println("4. Duracion");
        System.out.println("Seleccione el atributo por el cual desea ordenar la lista:");

        int option = scanner.nextInt();
        return option;
    }

    /**
     * Este método guarda el orden de ordenamiento dado por el cliente
     * Ascendente (A-Z) o Descendente (Z-A)
     * @return option
     */
    public int elegirOpcionOrden(){
        System.out.println("\n1. Ascendente / A-Z");
        System.out.println("2. Descendente / Z-A");
        System.out.println("Seleccione el orden de ordenamiento de la lista:");

        int option = scanner.nextInt();
        return option;
    }

    /**
     * Este método se encarga de guardar todas las métricas en un archivo para asi poder compararlas
     * Metricas: Método, Tiempo de ejecución, Intercambios, Comparaciones
     */
    public void metrics(){
        try {
            String ruta = "Sorts\\filesCSV\\Metricas";
            File file = new File(ruta);
            FileWriter Fw = new FileWriter(file);
            PrintWriter Pw = new PrintWriter(Fw);
            if (!file.exists()) {
                file.createNewFile();
            }
            for(int i = 0; i<metricas.size(); i++){
                String contenido = "Metodo: " + metricas.get(i).getMetodo() + ", Tiempo De ejecucion: " + metricas.get(i).getTiempoDeEjecucion() + ", Intercambios: " + metricas.get(i).getIntercambios() + ", Comparaciones: " + metricas.get(i).getComparaciones();
                Pw.println(contenido);
            } 
            Pw.close();
            Fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Este método funciona como interfaz
     * Guarda las opciones seleccionadas por el usuario
     * Llama a la funciono createCSV() para guardar los datos ordenados de cada método de ordenamiento en su respectivo CSV
     */
    public void menu (){
        atributoComp = elegirOpcionAtributo();
        if(atributoComp == 2){
            disableRadix = true;
        }
        atributoOrden = elegirOpcionOrden();
        BinaryInsertionSort<Pelicula> binaryInsertionSort = new BinaryInsertionSort<>();
        binaryInsertionSort.setTiempoInicio(System.currentTimeMillis());
        binaryInsertionSort.binaryInsertSort(listaPeliculas, atributoComp);
        binaryInsertionSort.setTiempoDeEjecucion(System.currentTimeMillis() - binaryInsertionSort.getTiempoInicio());
        tiempoDeEjecucion = binaryInsertionSort.getTiempoDeEjecucion();
        Intercambios = binaryInsertionSort.getIntercambios();
        Comparaciones = binaryInsertionSort.getComparaciones();
        metricas Metrica1 = new metricas(tiempoDeEjecucion, Comparaciones, Intercambios, "BinaryInsertionSort");
        metricas.add(Metrica1);
        createCSV("BinaryInsertionSort");

        if(!disableRadix){
            RadixSort radixSort = new RadixSort();
            radixSort.setTiempoInicio(System.currentTimeMillis());
            radixSort.radixSort(listaPeliculas, atributoComp);
            radixSort.setTiempoDeEjecucion(System.currentTimeMillis() - radixSort.getTiempoInicio());
            tiempoDeEjecucion = radixSort.getTiempoDeEjecucion();
            Intercambios = radixSort.getIntercambios();
            Comparaciones = radixSort.getComparaciones();
            metricas Metrica2 = new metricas(tiempoDeEjecucion, Comparaciones, Intercambios, "RadixSort");
            metricas.add(Metrica2);
            createCSV("RadixSort");
    
        }   

        MergeSort<Pelicula> mergeSort = new MergeSort<>();
        mergeSort.setTiempoInicio(System.currentTimeMillis());
        listaPeliculas = mergeSort.mergeSort(listaPeliculas, atributoComp);
        mergeSort.setTiempoDeEjecucion(System.currentTimeMillis() - mergeSort.getTiempoInicio());
        tiempoDeEjecucion = mergeSort.getTiempoDeEjecucion();
        Intercambios = mergeSort.getIntercambios();
        Comparaciones = mergeSort.getComparaciones();
        metricas Metrica3 = new metricas(tiempoDeEjecucion, Comparaciones, Intercambios, "MergeSort");
        metricas.add(Metrica3);
        createCSV("MergeSort");
                
        QuickSort<Pelicula> quicksort = new QuickSort<>();
        quicksort.setTiempoInicio(System.currentTimeMillis());
        quicksort.sort(listaPeliculas, atributoComp);
        quicksort.setTiempoDeEjecucion(System.currentTimeMillis() - quicksort.getTiempoInicio());
        tiempoDeEjecucion = quicksort.getTiempoDeEjecucion();
        Intercambios = quicksort.getIntercambios();
        Comparaciones = quicksort.getComparaciones();
        metricas Metrica4 = new metricas(tiempoDeEjecucion, Comparaciones, Intercambios, "QuickSort");
        metricas.add(Metrica4);
        createCSV("QuickSort");
        
    }

    /**
     * Este método crea un CSV con la informacion de una lista
     * Inserta la informacion dependiendo del orden dado por el usuario
     * @param filePath
     */
    public void createCSV(String filePath){
        try {
            String ruta = "Sorts\\filesCSV\\" + filePath +"Ordenado.csv";
            File file = new File(ruta);
            FileWriter Fw = new FileWriter(file);
            PrintWriter Pw = new PrintWriter(Fw);
            if (!file.exists()) {
                file.createNewFile();
            }
            switch(atributoOrden){
                case 1:
                    current = listaPeliculas.getLast();
                    while(current != null){
                        String contenido = current.getData().toString();
                        Pw.println(contenido);
                        current = current.previous;
                    }     
                    Pw.close();
                    Fw.close();
                break;
                case 2:
                    current = listaPeliculas.getFirst();
                    while(current != null){
                        String contenido = current.getData().toString();
                        Pw.println(contenido);
                        current = current.next;
                    }     
                    Pw.close();
                    Fw.close();
                break;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

}
