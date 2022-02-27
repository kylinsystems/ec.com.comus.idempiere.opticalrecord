package ec.com.comus.util;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ByteLookupTable;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.awt.image.ShortLookupTable;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import org.adempiere.exceptions.AdempiereException;



/**
 *
 * @author yuriani
 * @author Francisco Aguilar
 * @author Maricarmen Santos
 * @author Ivan luis Jimenez
 */
public class imagen extends javax.swing.JFrame implements ActionListener {

    /**
     *  crea un un objeto de otra clase llada RecortarImagen
     */
    RecortarImagen recorte;

    /**
     * variables globales de tipó bufferedImagen y variables de tipo entero.
     *
     */
    private BufferedImage imagen, imagen_filtro, copia;
    int w, h, opcion, grados = 0;
    double x1, y1;

    /**
     * constructor de la clase
     */
    public imagen() {
        initComponents();
        setTitle("Area Imagen");
    }

    /**
     * metodo que devuelve un valor de tipo entero.
     *
     * @param efecto
     */
    public void r_efecto(int efecto) {
        opcion = efecto;
    }

    /**
     * metodo set que recibe dos valores de tipo double
     *
     * @param x
     * @param y
     */
    public void tam(double x, double y) {
        x1 = x;
        y1 = y;
    }

    /**
     * arreglo estatico de tipo flotante para filtro sharpening
     */
    public static final float[] SHARPEN3x3 = {
        0.f, -1.f, 0.f,
        -1.f, 5.f, -1.f,
        0.f, -1.f, 0.f
    };
    /**
     * arreglo estatico de tipo flotante para filtro detectar bordes
     */
    public static final float[] valores = {
        0.0f, -1.0f, 0.0f,
        -1.0f, 4.0f, -1.0f,
        0.0f, -1.0f, 0.0f
    };
    /**
     * arreglo estatico de tipo flotante para filtro low-pass
     */
    public static final float[] BLUR3x3 = {
        0.1f, 0.1f, 0.1f,
        0.1f, 0.2f, 0.1f,
        0.1f, 0.1f, 0.1f
    };
    //variable estatica tipo short
    public static final short col = 256;
    /**
     * arreglo estatico de tipo flotante para filtro negativo
     */
    public static final short[] coloresInvertidos = new short[col];

    static {
        for (int i = 0; i < col; i++) {
            coloresInvertidos[i] = (short) ((col - 1) - i);
        }
    }
    /**
     * Arreglo para el eliminar el color rojo
     */
    static final short[] coloresSinInvertir_r = new short[col];
    static final short[] cr_cero = new short[col];

    /*Guarda azul*/
    static short[][] elimina_rojo = {
        cr_cero, coloresSinInvertir_r, coloresSinInvertir_r};

    static {
        for (int i = 0; i < col; i++) {
            coloresSinInvertir_r[i] = (short) (i);
            coloresInvertidos[i] = (short) ((col - 1) - i);
            cr_cero[i] = 0;
        }
    }

    /*Guarda rojo*/
    static short[][] elimina_azul = {
        coloresSinInvertir_r, cr_cero, coloresSinInvertir_r};

    /*Guarda Amarillo*/
    static short[][] elimina_verde = {
        coloresSinInvertir_r, coloresSinInvertir_r, cr_cero};


    /*Para ajuste de brillo*/
    public static float p = (float) 2;
    static final float[] componentes = {p, p, p};
    static final float[] desplazamientos = {0.0f, 0.0f, 0.0f};

    /**
     * Metodo para abrir la imagen con JfileChooser
     *
     * @return exportPath variable de tipo cadena
     */
    public String agregar_imagen() {

        JFileChooser file = new JFileChooser();//Objeto de tipo File Chosser para seleccionar la ruta de la imagen
        File ruta = null;// como la ruta cambia de direccion, la inicializo a null como contador

        int estado = file.showOpenDialog(null);//guardo el estado en un entero
        if (estado == JFileChooser.APPROVE_OPTION) {//Si presiono en aceptar entonces se procesa a guardar la direccion

            ruta = file.getSelectedFile();
            String exportPath = file.getSelectedFile().getAbsolutePath();
            System.out.println(exportPath);
            return exportPath;
        }
        return null;
    }//fin deñ metodo cargar imagen

    /**
     * metodo que carga la imagen al bufferedImagen ajustando el tamaño de la
     * ventana
     *
     */
    public void cargaImag(String url) {
        try {
//            String url = agregar_imagen();
            imagen = ImageIO.read(new File(url));

            w = imagen.getWidth(); // ancho
            h = imagen.getHeight(); //alto
            if (imagen.getType() != BufferedImage.TYPE_INT_RGB) {
                BufferedImage bi2
                        = new BufferedImage(imagen.getWidth(), imagen.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics big = bi2.getGraphics();
                big.drawImage(imagen, 0, 0, w, h, null);
                imagen_filtro = copia = imagen = bi2;
                throw new AdempiereException("Imagen cargada correctamente");
            }
            this.setSize(w, h);
        } catch (IOException e) {
            throw new AdempiereException("La imagen no se pudo leer");
            //System.exit(1);
        }
    } //fin del metodo cargarimagen

    /**
     * metodo que aplica filtros sobre la imagen original
     */
    public void agrega_filtro() {
        //declaracion de un buffered image
        BufferedImageOp destino = null;
        //estructura de seleccion switch
        switch (opcion) {
            case 9:
                /* Negativo */
                LookupTable lt = new ShortLookupTable(0, coloresInvertidos);
                destino = new LookupOp(lt, null);
                break;
            case 10:
                /*Detecta bordes*/
                float[] data1 = valores;
                destino = new ConvolveOp(new Kernel(3, 3, data1), ConvolveOp.EDGE_NO_OP, null);
                break;
            case 11:
                /* aumenta escala usando transform Op e interpolacion BICUBIC */
                AffineTransform at = AffineTransform.getScaleInstance(x1, y1);
                destino = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
                break;
            case 12:
            /* low pass filter */
            case 13:
                /* sharpen */
                float[] data = (opcion == 12) ? BLUR3x3 : SHARPEN3x3;
                destino = new ConvolveOp(new Kernel(3, 3, data), ConvolveOp.EDGE_NO_OP, null);
                break;
            case 14:
                /* lookup */
                byte lut[] = new byte[256];
                for (int j = 0; j < 256; j++) {
                    lut[j] = (byte) (256 - j);
                }
                ByteLookupTable blut = new ByteLookupTable(0, lut);
                destino = new LookupOp(blut, null);
                break;
            default:
        }
        try {
            imagen_filtro = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            destino.filter(imagen, imagen_filtro);
        } catch (Exception e) {
            System.out.print("");
        }

    } // fin metodo agrega filtro

    /**
     * metetodo que pinta sobre el panel
     *
     * @param g variable de tipo graphics
     */
    @Override
    public void paint(Graphics g) {
        //limpia contenido de contexto grafico
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        switch (opcion) {
            case 0:
                /*Imagen Original*/
                imagen_filtro = imagen;
                g.drawImage(imagen, 0, 0, null);
                break;
            case 1:
                /*Azul*/
                LookupTable azul = new ShortLookupTable(0, elimina_rojo);
                LookupOp az = new LookupOp(azul, null);
                imagen_filtro = az.filter(imagen, null);
                g.drawImage(imagen_filtro, 0, 0, null);
                break;
            case 2:
                /*Brillo*/
                RescaleOp rop2 = new RescaleOp(componentes, desplazamientos, null);
                imagen_filtro = rop2.filter(imagen, null);
                g.drawImage(imagen_filtro, 0, 0, null);
                break;
            case 3:
                /*Gris*/
                ColorConvertOp ccop = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
                imagen_filtro = ccop.filter(imagen, null);
                g.drawImage(imagen_filtro, 0, 0, null);
                break;
            case 4:
                /*Girar*/
                double r = Math.toRadians(grados); //se convierte a radianes lo grados
                AffineTransform a = new AffineTransform();
                a.rotate(r, this.getWidth() / 2, this.getHeight() / 2); //se asigna el angulo y centro de rotacion
                ((Graphics2D) g).setTransform(a);
                g.drawImage(imagen_filtro, 0, 0, this);
                break;
            case 5:
                /*Amarillo*/
                LookupTable amarillo = new ShortLookupTable(0, elimina_verde);
                LookupOp ye = new LookupOp(amarillo, null);
                imagen_filtro = ye.filter(imagen, null);
                g.drawImage(imagen_filtro, 0, 0, null);
                break;
            case 6:
                /*Filtro Rojo*/
                LookupTable rojo = new ShortLookupTable(0, elimina_azul);
                LookupOp ro = new LookupOp(rojo, null);
                imagen_filtro = ro.filter(imagen, null);
                g.drawImage(imagen_filtro, 0, 0, null);
                break;
            case 7:
                /*Efecto Espejo*/
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-copia.getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                imagen_filtro = op.filter(imagen_filtro, null);
                g.drawImage(imagen_filtro, 0, 0, null);
                break;
            default:
                //apĺica los filtros  que estan dentro del metodo agrega_filtro
                agrega_filtro();
                g.drawImage(imagen_filtro, 0, 0, null);
                break;
        }
    }// fin de paint

    /**
     * este metodo rota la imagen recibibiendo los grados de tipo double
     * llamando los metodos rotar y translacion final de la clase transformar
     * imagen
     *
     * @param grados variable de tipo double
     * @return devuelve un objeto de tipo buffered imagen
     */
    public BufferedImage rotacionImagen(double grados) {
        //crea un objeto  transformar de la clase transformar imagen
        TransformarImagen Transformar = new TransformarImagen(imagen.getHeight(), imagen.getWidth());
        //llama al metodo rotar
        Transformar.rotar(grados);
        //llama al metodo tranlacion final
        Transformar.Traslacionfinal();
        //se crea un objeto de la clase AffineTransformOp
        AffineTransformOp nuevo = new AffineTransformOp(Transformar.Trans(), AffineTransformOp.TYPE_BILINEAR);
        /*
        	createCompatibleDestImage(BufferedImage src, ColorModel destCM)
                Crea una imagen de destino puesto a cero con el tamaño y número de bandas correcta.
         */
        imagen_filtro = nuevo.createCompatibleDestImage(imagen, imagen.getColorModel());
        /*
            filter(BufferedImage src, BufferedImage dest)
            Realiza una operación con una sola entrada / salida única en una BufferedImage.
         */
        imagen = nuevo.filter(imagen, imagen_filtro);
        //retorna imagen
        return imagen;
    }

    /**
     * metodo set que actualiza el frame
     */
    public void actualiza_frame() {
        this.setSize(imagen.getWidth(), imagen.getHeight());
    }

    /**
     * metodo que modifica los grados a girar
     *
     * @param grados variable de tipo entero
     */
    public void Grados(int grados) {
        this.grados = grados;
        repaint();
    }

    /**
     * metodo que devuelve el objeto imagen filtro
     *
     * @return imagen_filtro variable de tipo bufferedImage
     */
    public BufferedImage getBi() {
        return imagen_filtro;
    }
/**
 * metodo que recorta una parte de la imagen
 */
    public void RecortarImagen() {
        recorte = new RecortarImagen(imagen_filtro);
        this.label.removeAll();
        this.label.add(recorte);

        recorte.TamanioRecorte(design.TAncho.getValue());
        design.TAncho.setMaximum(imagen_filtro.getHeight());

        this.label.repaint();

    }
/**
 * metodo que guarda el recorte 
 */
    public void GuardarRecorte(File saveFile) {
            recorte.guardar_imagen(saveFile, "png");
  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();

//        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        label.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
        );
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2)-100;
        int y = (int) (screenSize.getHeight() / 2);
        this.setLocation(x, y);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
