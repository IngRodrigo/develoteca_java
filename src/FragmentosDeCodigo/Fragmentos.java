/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FragmentosDeCodigo;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author rodsanchez
 */
public class Fragmentos {
//Funciona - descomentar para probar
    
//    public void controlarAperturaVentanas(JInternalFrame inter, String titulo, JFrame menuPrincipal) {
//        /**
//         EL escritorio es el JDesktopPane que debe estar dentro del menu principal
//         ***/
//        boolean mostrar = true;
//        inter.setTitle(titulo);
//        inter.setClosable(true);
//        String Nombre = inter.getTitle();
//        for (int a = 0; a < menuPrincipal.escritorio.getComponentCount(); a++) {     // verificar si es instancia de algun componente que ya este en el jdesktoppane
//            if (inter.getClass().isInstance(menuPrincipal.escritorio.getComponent(a))) {
//                JOptionPane.showMessageDialog(null, "La ventana " + Nombre + " que interta abrir ya está abierta, cierre la ventana actual e intente nuevamente");
//                System.out.println("esta instancia, no se debe mostrar");
//                inter.toFront();
//                menuPrincipal.escritorio.moveToFront(inter);
//                mostrar = false;
//
//            } else {
//                System.out.println("no lo es, puede mostrarse");
//            }
//        }
//        if (mostrar) {
//            //inter.setSize(50,5);
//            menuPrincipal.escritorio.add(inter);
//        }
//        inter.show();
//    }
}
