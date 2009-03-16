/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RegistroContactos.java
 *
 * Created on 21/02/2009, 04:16:20 PM
 */

package miCrm.vista.sistema;

import java.awt.Color;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lib.model.miCRM.Articulo;
import lib.model.miCRM.Cliente;
import lib.model.miCRM.Contacto;
import lib.model.miCRM.EstadoContacto;
import lib.model.miCRM.Prioridad;
import lib.model.miCRM.TipoContacto;
import lib.model.miCRM.Usuario;
import lib.utilities.DateUtilities;
import miCrm.Conf;
import miCrm.Fachada;
import miCrm.vista.admin.Clientes;

/**
 *
 * @author Administrator
 */
public class ConsolaTecnico extends javax.swing.JDialog {
    private JFrame ventanaPadre = null;
    /** Creates new form RegistroContactos */
    public ConsolaTecnico(JFrame parent) {
      super(parent);
      this.ventanaPadre = parent;
      initComponents();
      cargarListas();
      cargarCamposAutomaticos();
      cargarPendientes();
    }

  void solucionBase(Contacto contacto) {
    tResolucion.setEnabled(true);
    if (contacto!=null) {
      tResolucion.setText(contacto.getResolucion());
    }
    else {
      tResolucion.setText("Por favor, documente la solución lo mas detalladamente posible.");
    }
  }

  private void agregarArticulo() {
    if (lArticulos.getSelectedIndex()==-1) {
      JOptionPane.showMessageDialog(
        this,"Debe seleccionar un artículo a agregar",
        "Error al agregar",
        JOptionPane.ERROR_MESSAGE);
    }
    else {
        listaArticulosContacto.addElement(lArticulos.getSelectedValue());
    }
  }

  private boolean bloqueante() {
    
    for (Object o : lista.toArray()) {
      Contacto u = (Contacto) o;
      if (u.getPrioridad().equals(Conf.PRIORIDAD_BLOQUENATE)) {
        return true;
      }
    }
    return false;
  }

  private void buscarCliente() {
      String cliente[] = tCliente.getText().split(",");
      ArrayList<Cliente> losClientes = null;
      if (cliente.length==2) {
        losClientes = Fachada.buscarClientePorApellidoNombre(cliente[1].trim(), cliente[0].trim());
      }
      else {
        losClientes = Fachada.buscarClientePorNombre(tCliente.getText().trim());
      }
      if (losClientes.size()!=1) {
        tCliente.setForeground(Color.red);
        mostrarClientes();
      }
      else {
        tCliente.setForeground(Color.BLACK);
        elCliente = losClientes.get(0);
        tCliente.setText(elCliente.toString());
      }    
  }

  private void cargarCamposAutomaticos() {        
    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hora = new SimpleDateFormat("H:mm");
    tFecha.setText(fecha.format(new Date()));
    tHora.setText(hora.format(new Date()));    
    cTecnico.setSelectedItem(Conf.TECNICO_POR_DEFECTO);
    cPrioridad.setSelectedItem(Conf.PRIORIDAD_POR_DEFECTO);
  }

  private void cargarDatos(Contacto c) {
    try {      
      tId.setText(c.getId().toString());
      tFecha.setText(DateUtilities.parseTimestamp(c.getRecibidoEl(),DateUtilities.DATE_FORMAT));
      tHora.setText(DateUtilities.parseTimestamp(c.getRecibidoEl(),DateUtilities.TIME_FORMAT));
      tTelefono.setText(c.getNumeroEntrante().toString());
      tCliente.setText(c.getCliente().toString());
      elCliente = c.getCliente();
      cEstado.setSelectedItem(c.getEstadoContacto());
      cEstado.setEnabled(true);
      cPrioridad.setSelectedItem(c.getPrioridad());
      cTecnico.setSelectedItem(c.getTecnico());
      cTelefonista.setSelectedItem(c.getTelefonista());
      tDescripcion.setText(c.getDesc().toString());
      if (c.getEstadoContacto().equals(Conf.ESTADO_NUEVO_CONTACTO)) {
        cEstado.setSelectedItem(Conf.ESTADO_ASIGNADO);
      }
      else {
        cEstado.setSelectedItem(c.getEstadoContacto());
      }
      //cPrioridad.setSelectedItem(c.getPrioridad());
      //cTecnico.setSelectedItem(c.getTecnico());
      this.listaArticulosContacto.clear();
      if (c.getArticulos()!=null) {
        for (Articulo u : c.getArticulos()) {
          this.lista.addElement(u);
        }
      }
    } catch (Exception e) {
      System.out.println(e.toString());
      JOptionPane.showMessageDialog(
        this,"No se pudieron cargar los datos del contacto",
        "Error al cargar",
        JOptionPane.ERROR_MESSAGE);
    }
  }

  private void cargarListas() {
    this.listaArticulos.clear();
    for (Articulo u : Fachada.listarArticulos()) {
      this.listaArticulos.addElement(u);
    }
    cEstado.removeAllItems();
    for (EstadoContacto e : Fachada.listarEstados()) {
      cEstado.addItem(e);
    }
    cPrioridad.removeAllItems();
    for (Prioridad e : Fachada.listarPrioridades()) {
      cPrioridad.addItem(e);
    }
    cTecnico.removeAllItems();
    for (Usuario e : Fachada.listarTecnicos()) {
      cTecnico.addItem(e);
    }
    cTelefonista.removeAllItems();
    for (Usuario e : Fachada.listarTelefonistas()) {
      cTelefonista.addItem(e);
    }
    cTipoContacto.removeAllItems();
    for (TipoContacto e : Fachada.listarTipoContactos()) {
      cTipoContacto.addItem(e);
    }
  }

  private void cargarPendientes() {
    this.lista.clear();
    for (Contacto u : Fachada.listarContactosPorTecnicoSinFinalizar(Conf.getUsuarioLogueado())) {
      this.lista.addElement(u);
      if (u.getPrioridad().equals(Conf.PRIORIDAD_BLOQUENATE)) {
        cargarDatos(u);
      }
    }

  }

  private void guardarContacto() {
    try {
      Contacto c = Fachada.buscarContactoPorId(Integer.parseInt(tId.getText()));
      c.setEstadoContacto((EstadoContacto) cEstado.getSelectedItem());
      c.setResolucion(tResolucion.getText());
      c.setTiempoResolucion(Integer.parseInt(tTiempo.getText()));
      c.limpiarArticulos();
      for (Object o : listaArticulosContacto.toArray()) {
        c.agregarArticulo((Articulo) o);
      }
      if (c.guardar()) {
        JOptionPane.showMessageDialog(
            this,"Contacto guardado",
            "Contacto guardado",
            JOptionPane.INFORMATION_MESSAGE);
        cargarListas();
        cargarPendientes();
      }
      else {
        throw new Exception("falló guardar()");
      }
      limpiarCampos();
    } catch (Exception e) {
      System.out.println(e.toString());
      JOptionPane.showMessageDialog(
            this,"Error al guardar el Contacto. Verifique los datos.\r\n"+
            "Si el error persiste, por favor consulte con el administrador.\r\n"
            +e.toString(),
            "Error al guardar",
            JOptionPane.ERROR_MESSAGE);
    }

  }

  private void habilitarIngreso() {
    if (((EstadoContacto) cEstado.getSelectedItem()).equals(Conf.ESTADO_EN_PROCESO)) {
      tTiempo.setEnabled(true);
      bAgregar.setEnabled(false);
      bQuitar.setEnabled(false);
      lArticulos.setEnabled(false);
      lArticulosContacto.setEnabled(false);
      listaArticulosContacto.removeAllElements();
      tTiempo.setText("3");
    }
    else if (((EstadoContacto) cEstado.getSelectedItem()).equals(Conf.ESTADO_EN_VISITA)) {
      tTiempo.setEnabled(false);
      tTiempo.setText("");
      bAgregar.setEnabled(true);
      bQuitar.setEnabled(true);
      lArticulos.setEnabled(true);
      lArticulosContacto.setEnabled(true);
    }
  }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    pControlAsignaciones = new javax.swing.JSplitPane();
    pAsignacionContacto = new javax.swing.JPanel();
    lDescipcion = new javax.swing.JLabel();
    ltipoContacto = new javax.swing.JLabel();
    lPrioridad = new javax.swing.JLabel();
    lEstado = new javax.swing.JLabel();
    lTecnico = new javax.swing.JLabel();
    tCliente = new javax.swing.JTextField();
    sDescripcion = new javax.swing.JScrollPane();
    tDescripcion = new javax.swing.JTextArea();
    cTecnico = new javax.swing.JComboBox();
    cPrioridad = new javax.swing.JComboBox();
    cEstado = new javax.swing.JComboBox();
    cTipoContacto = new javax.swing.JComboBox();
    bGuardar = new javax.swing.JButton();
    bCancelar = new javax.swing.JButton();
    lTelefono = new javax.swing.JLabel();
    lCliente = new javax.swing.JLabel();
    lFecha = new javax.swing.JLabel();
    lHora = new javax.swing.JLabel();
    tTelefono = new javax.swing.JTextField();
    tFecha = new javax.swing.JTextField();
    tHora = new javax.swing.JTextField();
    lIcon = new javax.swing.JLabel();
    lId = new javax.swing.JLabel();
    tId = new javax.swing.JTextField();
    lTelefonista = new javax.swing.JLabel();
    cTelefonista = new javax.swing.JComboBox();
    bAgregar = new javax.swing.JButton();
    bQuitar = new javax.swing.JButton();
    sArticulos = new javax.swing.JScrollPane();
    listaArticulos = new DefaultListModel();
    lArticulos = new javax.swing.JList(listaArticulos);
    sArticulosContacto = new javax.swing.JScrollPane();
    listaArticulosContacto = new DefaultListModel();
    lArticulosContacto = new javax.swing.JList(listaArticulosContacto);
    sResolucion = new javax.swing.JScrollPane();
    tResolucion = new javax.swing.JTextArea();
    lResolucion = new javax.swing.JLabel();
    ltiempo = new javax.swing.JLabel();
    tTiempo = new javax.swing.JTextField();
    bBuscar = new javax.swing.JButton();
    lReparados = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    sContactos = new javax.swing.JScrollPane();
    lista = new DefaultListModel();
    lContactos = new javax.swing.JList(lista);

    setTitle("Registro de Contactos");

    pControlAsignaciones.setDividerLocation(300);
    pControlAsignaciones.setLastDividerLocation(300);

    pAsignacionContacto.setMinimumSize(new java.awt.Dimension(250, 0));

    lDescipcion.setText("Descripción");

    ltipoContacto.setText("Tipo Contacto");

    lPrioridad.setText("Prioridad");

    lEstado.setText("Estado");

    lTecnico.setText("Tecnico");

    tCliente.setEnabled(false);
    tCliente.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tClienteActionPerformed(evt);
      }
    });
    tCliente.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        tClienteFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        tClienteFocusLost(evt);
      }
    });

    tDescripcion.setColumns(20);
    tDescripcion.setRows(5);
    tDescripcion.setEnabled(false);
    sDescripcion.setViewportView(tDescripcion);

    cTecnico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    cTecnico.setEnabled(false);
    cTecnico.setMinimumSize(new java.awt.Dimension(150, 20));
    cTecnico.setPreferredSize(new java.awt.Dimension(150, 22));

    cPrioridad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    cPrioridad.setEnabled(false);
    cPrioridad.setMinimumSize(new java.awt.Dimension(150, 20));
    cPrioridad.setPreferredSize(new java.awt.Dimension(150, 22));

    cEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    cEstado.setEnabled(false);
    cEstado.setMinimumSize(new java.awt.Dimension(150, 20));
    cEstado.setPreferredSize(new java.awt.Dimension(150, 22));
    cEstado.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cEstadoActionPerformed(evt);
      }
    });

    cTipoContacto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    cTipoContacto.setEnabled(false);

    bGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/disk.png"))); // NOI18N
    bGuardar.setText("Guardar");
    bGuardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bGuardarActionPerformed(evt);
      }
    });

    bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/cancel.png"))); // NOI18N
    bCancelar.setText("Cancelar");
    bCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bCancelarActionPerformed(evt);
      }
    });

    lTelefono.setText("Telefono Origen");

    lCliente.setText("Cliente");

    lFecha.setText("Fecha");

    lHora.setText("Hora");

    tTelefono.setEnabled(false);
    tTelefono.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tTelefonoActionPerformed(evt);
      }
    });

    tFecha.setEnabled(false);
    tFecha.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tFechaActionPerformed(evt);
      }
    });

    tHora.setEnabled(false);
    tHora.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tHoraActionPerformed(evt);
      }
    });

    lIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/29.png"))); // NOI18N

    lId.setText("Id");

    tId.setEnabled(false);
    tId.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tIdActionPerformed(evt);
      }
    });

    lTelefonista.setText("Telefonista");

    cTelefonista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    cTelefonista.setEnabled(false);
    cTelefonista.setMinimumSize(new java.awt.Dimension(150, 20));
    cTelefonista.setPreferredSize(new java.awt.Dimension(150, 22));

    bAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/add.png"))); // NOI18N
    bAgregar.setText("Agregar");
    bAgregar.setEnabled(false);
    bAgregar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bAgregarActionPerformed(evt);
      }
    });

    bQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/delete.png"))); // NOI18N
    bQuitar.setText("Quitar");
    bQuitar.setEnabled(false);
    bQuitar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bQuitarActionPerformed(evt);
      }
    });

    lArticulos.setEnabled(false);
    sArticulos.setViewportView(lArticulos);

    lArticulosContacto.setEnabled(false);
    sArticulosContacto.setViewportView(lArticulosContacto);

    tResolucion.setColumns(20);
    tResolucion.setRows(5);
    tResolucion.setEnabled(false);
    sResolucion.setViewportView(tResolucion);

    lResolucion.setText("Resolución");

    ltiempo.setText("Tiempo resolución");

    tTiempo.setEnabled(false);

    bBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/magnifier.png"))); // NOI18N
    bBuscar.setText("Buscar");
    bBuscar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bBuscarActionPerformed(evt);
      }
    });

    lReparados.setText("Articulos reparados");

    jLabel2.setText("Articulos disponibles");

    javax.swing.GroupLayout pAsignacionContactoLayout = new javax.swing.GroupLayout(pAsignacionContacto);
    pAsignacionContacto.setLayout(pAsignacionContactoLayout);
    pAsignacionContactoLayout.setHorizontalGroup(
      pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pAsignacionContactoLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(pAsignacionContactoLayout.createSequentialGroup()
            .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(lCliente)
              .addComponent(ltipoContacto)
              .addComponent(lDescipcion)
              .addComponent(lId)
              .addComponent(lHora)
              .addComponent(lFecha)
              .addComponent(lTelefonista)
              .addComponent(lTelefono)
              .addComponent(lEstado)
              .addComponent(lPrioridad)
              .addComponent(lTecnico))
            .addGap(52, 52, 52)
            .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(cTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(cPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(cEstado, 0, 279, Short.MAX_VALUE)
              .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(tHora, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cTipoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pAsignacionContactoLayout.createSequentialGroup()
                  .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(lIcon))
                .addComponent(cTelefonista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addComponent(sDescripcion)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(pAsignacionContactoLayout.createSequentialGroup()
                .addComponent(ltiempo)
                .addContainerGap())
              .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pAsignacionContactoLayout.createSequentialGroup()
                  .addComponent(lReparados)
                  .addGap(47, 47, 47)
                  .addComponent(jLabel2)
                  .addGap(182, 182, 182))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAsignacionContactoLayout.createSequentialGroup()
                  .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pAsignacionContactoLayout.createSequentialGroup()
                      .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addComponent(lResolucion, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sArticulosContacto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(sArticulos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addComponent(bAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addComponent(bBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                    .addComponent(sResolucion, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                  .addGap(142, 142, 142)))))
          .addGroup(pAsignacionContactoLayout.createSequentialGroup()
            .addComponent(bGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bCancelar)
            .addGap(632, 632, 632))))
    );

    pAsignacionContactoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bCancelar, bGuardar});

    pAsignacionContactoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bAgregar, bQuitar, sArticulos, sArticulosContacto});

    pAsignacionContactoLayout.setVerticalGroup(
      pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pAsignacionContactoLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(pAsignacionContactoLayout.createSequentialGroup()
            .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(pAsignacionContactoLayout.createSequentialGroup()
                .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(tFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(lFecha)))
              .addComponent(lId))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(tHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(lHora))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(cTelefonista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(lTelefonista))
            .addGap(7, 7, 7)
            .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(tTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(lTelefono))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(tCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(lCliente)))
          .addGroup(pAsignacionContactoLayout.createSequentialGroup()
            .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(bBuscar)
              .addComponent(lResolucion)
              .addComponent(lIcon))
            .addGap(5, 5, 5)
            .addComponent(sResolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cTipoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ltipoContacto)
          .addComponent(lReparados)
          .addComponent(jLabel2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(pAsignacionContactoLayout.createSequentialGroup()
            .addGap(21, 21, 21)
            .addComponent(lDescipcion))
          .addComponent(sDescripcion, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(sArticulosContacto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
          .addComponent(sArticulos, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
        .addGap(6, 6, 6)
        .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(bAgregar)
          .addComponent(bQuitar)
          .addComponent(cEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lEstado))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lPrioridad)
          .addComponent(ltiempo)
          .addComponent(tTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lTecnico))
        .addGap(26, 26, 26)
        .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(bGuardar)
          .addComponent(bCancelar))
        .addContainerGap())
    );

    pControlAsignaciones.setRightComponent(pAsignacionContacto);

    lContactos.setModel(lista);
    lContactos.setMinimumSize(new java.awt.Dimension(250, 0));
    lContactos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        lContactosValueChanged(evt);
      }
    });
    sContactos.setViewportView(lContactos);

    pControlAsignaciones.setLeftComponent(sContactos);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(pControlAsignaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(pControlAsignaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void limpiarCampos() {
    cargarCamposAutomaticos();
    tId.setText("");
    tFecha.setText("");
    cTelefonista.setSelectedItem(null);
    tTelefono.setText("");
    cTipoContacto.setSelectedItem(null);
    cEstado.setSelectedItem(null);
    cPrioridad.setSelectedItem(null);
    cTecnico.setSelectedItem(null);
    tDescripcion.setText("");
    tResolucion.setText("");
    tResolucion.setEnabled(false);
    bAgregar.setEnabled(false);
    bQuitar.setEnabled(false);
    listaArticulosContacto.removeAllElements();
    lArticulos.setEnabled(false);
    lArticulosContacto.setEnabled(false);
    tTiempo.setText("");
    tTiempo.setEnabled(false);
    tCliente.setText("");
    this.listaArticulosContacto.clear();
  }
  private void mostrarClientes() {
      Clientes vClientes = new Clientes((JDialog) this);
      vClientes.setVisible(true);
  }
  public void seleccionarCliente(Object selectedValue) {
    try {
      Cliente unCliente = (Cliente) selectedValue;
      tCliente.setText(unCliente.toString());
      tCliente.setForeground(Color.black);
      this.elCliente = unCliente;
    } catch (Exception e) {
      System.out.println("fallo SeleccionarCliente");
    }
  }

  private void quitarArticulo() {
    if (lArticulosContacto.getSelectedIndex()==-1) {
      JOptionPane.showMessageDialog(
        this,"Debe seleccionar un artículo a quitar",
        "Error al quitar",
        JOptionPane.ERROR_MESSAGE);
    }
    else {
        listaArticulosContacto.remove(lArticulosContacto.getSelectedIndex());
    }
  }

    private void tFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tFechaActionPerformed
      // TODO add your handling code here:
}//GEN-LAST:event_tFechaActionPerformed

    private void tHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tHoraActionPerformed
      // TODO add your handling code here:
}//GEN-LAST:event_tHoraActionPerformed

    private void tClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tClienteActionPerformed
      // TODO add your handling code here:
      
}//GEN-LAST:event_tClienteActionPerformed

    private void tTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tTelefonoActionPerformed
      // TODO add your handling code here:
}//GEN-LAST:event_tTelefonoActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
      if (validarDatos()) {
        guardarContacto();
      }
      else {
        JOptionPane.showMessageDialog(
        this,"Error en los datos de entrada.\r\n Por favor verifique.",
        "Error en datos",
        JOptionPane.ERROR_MESSAGE);
      }
}//GEN-LAST:event_bGuardarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
    this.dispose();
}//GEN-LAST:event_bCancelarActionPerformed

    private void tClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tClienteFocusGained

    }//GEN-LAST:event_tClienteFocusGained

    private void tClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tClienteFocusLost
      buscarCliente();
    }//GEN-LAST:event_tClienteFocusLost

    private void tIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdActionPerformed
      // TODO add your handling code here:
}//GEN-LAST:event_tIdActionPerformed

    private void lContactosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lContactosValueChanged
      if (lContactos.getSelectedIndex()!=-1) {
        if (!bloqueante()) {
          cargarDatos((Contacto) lContactos.getSelectedValue());
        }
        else {
          JOptionPane.showMessageDialog(
            this,"Tiene una tarea bloqueante. No puede trabajar en otra hasta que la misma esté cerrada.",
            "Tarea Bloqueante pendiente",
            JOptionPane.INFORMATION_MESSAGE);
        }
      }
    }//GEN-LAST:event_lContactosValueChanged

    private void bAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarActionPerformed
      agregarArticulo();
}//GEN-LAST:event_bAgregarActionPerformed

    private void bQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bQuitarActionPerformed
      quitarArticulo();
}//GEN-LAST:event_bQuitarActionPerformed

    private void cEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cEstadoActionPerformed
      if (cEstado.getSelectedIndex()!=-1) {
        habilitarIngreso();
      }
    }//GEN-LAST:event_cEstadoActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
      BuscarSoluciones vBuscarSoluciones = new BuscarSoluciones((JDialog) this);
      vBuscarSoluciones.setVisible(true);
    }//GEN-LAST:event_bBuscarActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bAgregar;
  private javax.swing.JButton bBuscar;
  private javax.swing.JButton bCancelar;
  private javax.swing.JButton bGuardar;
  private javax.swing.JButton bQuitar;
  private javax.swing.JComboBox cEstado;
  private javax.swing.JComboBox cPrioridad;
  private javax.swing.JComboBox cTecnico;
  private javax.swing.JComboBox cTelefonista;
  private javax.swing.JComboBox cTipoContacto;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JList lArticulos;
  private javax.swing.JList lArticulosContacto;
  private javax.swing.JLabel lCliente;
  private javax.swing.JList lContactos;
  private javax.swing.JLabel lDescipcion;
  private javax.swing.JLabel lEstado;
  private javax.swing.JLabel lFecha;
  private javax.swing.JLabel lHora;
  private javax.swing.JLabel lIcon;
  private javax.swing.JLabel lId;
  private javax.swing.JLabel lPrioridad;
  private javax.swing.JLabel lReparados;
  private javax.swing.JLabel lResolucion;
  private javax.swing.JLabel lTecnico;
  private javax.swing.JLabel lTelefonista;
  private javax.swing.JLabel lTelefono;
  private javax.swing.JLabel ltiempo;
  private javax.swing.JLabel ltipoContacto;
  private javax.swing.JPanel pAsignacionContacto;
  private javax.swing.JSplitPane pControlAsignaciones;
  private javax.swing.JScrollPane sArticulos;
  private javax.swing.JScrollPane sArticulosContacto;
  private javax.swing.JScrollPane sContactos;
  private javax.swing.JScrollPane sDescripcion;
  private javax.swing.JScrollPane sResolucion;
  private javax.swing.JTextField tCliente;
  private javax.swing.JTextArea tDescripcion;
  private javax.swing.JTextField tFecha;
  private javax.swing.JTextField tHora;
  private javax.swing.JTextField tId;
  private javax.swing.JTextArea tResolucion;
  private javax.swing.JTextField tTelefono;
  private javax.swing.JTextField tTiempo;
  // End of variables declaration//GEN-END:variables
  DefaultListModel lista = new DefaultListModel();
  DefaultListModel listaArticulos = new DefaultListModel();
  DefaultListModel listaArticulosContacto = new DefaultListModel();
  DefaultListModel listaClientes = new DefaultListModel();
  Cliente elCliente = null;
  
  private boolean validarDatos() {
    try {
      Integer id = Integer.parseInt(tId.getText());
      if (cTipoContacto.getSelectedIndex()==-1) {
        return false;
      }
      if (cEstado.getSelectedIndex()==-1) {
        return false;
      }
      if (tResolucion.getText().length()<Conf.MIN_LEN_RESOLUCION) {
        return false;
      }
      if (((EstadoContacto) cEstado.getSelectedItem()).equals(Conf.ESTADO_EN_PROCESO)) {
        Integer tiempo = Integer.parseInt(tTiempo.getText());
      }
      if (cPrioridad.getSelectedIndex()==-1) {
        return false;
      }
      if (cTecnico.getSelectedIndex()==-1) {
        return false;
      }
      if (elCliente==null) {
        return false;
      }
      if (tTelefono.getText().length()<3) {
        return false;
      }
      if (tDescripcion.getText().length()<3) {
        return false;
      }
      if (tDescripcion.getText().length()>Conf.MAX_LEN_DESC) {
        return false;
      }
      if (cTipoContacto.getSelectedIndex()==-1) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
