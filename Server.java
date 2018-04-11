import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JOptionPane;
public class Server extends javax.swing.JFrame {
AudioInputStream audioInputStream;
static AudioInputStream ais;
static AudioFormat format;
static boolean status = true;
static int port = 50005;
static int sampleRate = 50000;
int count=0;
double volume=0.0;
boolean bool=true;
static DataLine.Info dataLineInfo;
static SourceDataLine sourceDataLine;
    /** Creates new form CountDown */
    public Server() {
        super("     Server Software");
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtmsg1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        start = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        slider = new javax.swing.JSlider();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        txtmsg1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        txtmsg1.setForeground(new java.awt.Color(255, 51, 102));

        exit.setBackground(new java.awt.Color(255, 0, 51));
        exit.setFont(new java.awt.Font("Tahoma", 1, 24));
        exit.setForeground(new java.awt.Color(153, 153, 153));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        exit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                exitFocusGained(evt);
            }
        });
        exit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                exitKeyPressed(evt);
            }
        });

        start.setBackground(new java.awt.Color(51, 255, 102));
        start.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        start.setForeground(new java.awt.Color(102, 102, 102));
        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        start.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                startFocusGained(evt);
            }
        });
        start.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                startKeyPressed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(51, 102, 255));
        jLabel7.setFont(new java.awt.Font("MS Mincho", 3, 24));
        jLabel7.setForeground(new java.awt.Color(153, 204, 0));
        jLabel7.setText("Meeting , Conference and Presentation  Speaker service center");

        slider.setMajorTickSpacing(10);
        slider.setMaximum(50);
        slider.setMinorTickSpacing(2);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtmsg1, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmsg1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(start, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        bool=false;
        start.setVisible(true);
        exit.setVisible(false);
        System.exit(1); 
    }//GEN-LAST:event_exitActionPerformed

    private void exitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exitFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_exitFocusGained

    private void exitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exitKeyPressed
        
        
    }//GEN-LAST:event_exitKeyPressed

private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
start.setVisible(false);
exit.setVisible(true);
            Runnable r = new Runnable() {
            @Override
         public void run() {
                try {
                    connect();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }; 
            new Thread(r).start();   
}//GEN-LAST:event_startActionPerformed

private void startFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_startFocusGained
 // TODO add your handling code here:
}//GEN-LAST:event_startFocusGained

private void startKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startKeyPressed
 // TODO add your handling code here:
}//GEN-LAST:event_startKeyPressed

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged

       /* volume=slider.getValue();      
        Server s = new Server();
        Thread t = new Thread(s);
        t.start();
         TODO add your handling code here:
         * 
         * 
         */
    }//GEN-LAST:event_sliderStateChanged

     public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

     
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Server().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSlider slider;
    private javax.swing.JButton start;
    private javax.swing.JLabel txtmsg1;
    // End of variables declaration//GEN-END:variables

    private void connect() throws IOException {              
                 try {
        DatagramSocket serverSocket = new DatagramSocket(port);
            //txt.setText("Server is started !\n");
            /*
             * Formula for lag = (byte_size/sample_rate)*2
             * Byte size 9728 will produce ~ 0.45 seconds of lag. Voice slightly broken.
             * Byte size 1400 will produce ~ 0.06 seconds of lag. Voice extremely broken.
             * Byte size 4000 will produce ~ 0.18 seconds of lag. Voice slightly more broken then 9728.             
             */
            byte[] receiveData = new byte[2048];
            
            format = new AudioFormat(sampleRate, 16, 1, true, false);
            dataLineInfo = new DataLine.Info(SourceDataLine.class, format);
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
            sourceDataLine.open(format);
            sourceDataLine.start();

            FloatControl volumeControl = (FloatControl) sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(1.00f);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            ByteArrayInputStream baiss = new ByteArrayInputStream(receivePacket.getData());
            while (status == true) { 
                serverSocket.receive(receivePacket); 
                
                ais = new AudioInputStream(baiss, format, receivePacket.getLength());
                toSpeaker(receivePacket.getData());
            }
            sourceDataLine.drain();
            sourceDataLine.close();
        }
             catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }        catch (LineUnavailableException ex) {
                          Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }           
       }
    
public static void toSpeaker(byte soundbytes[]) {
    
    try {
        sourceDataLine.write(soundbytes, 0, soundbytes.length);
    } catch (Exception e) {
            String message = e.getMessage(); //
            JOptionPane.showMessageDialog(null,message+" Not working in speakers...");
    }
}

    private void Volume() {
      Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        for (Mixer.Info mixerInfo : mixers) {
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            for (Line.Info lineInfo : lineInfos) {
                Line line = null;
                boolean opened = true;
                try {
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    if (!opened) {
                        line.open();
                    }
                    FloatControl volCtrl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    System.out.println(volume);
                    volCtrl.setValue((float) volume);
                  //System.out.println("    volCtrl.getValue() = " + volCtrl.getValue());
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException iaEx) {
                } finally {
                    if (line != null && !opened) {
                        line.close();
                    }
                }
            }
        }  
    } 
}
 
 
