
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MidiTut {

	/**
	 * @param args
	 * @throws MidiUnavailableException 
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MidiUnavailableException {
		// TODO Auto-generated method stub
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();
		
		final MidiChannel [] mc = synth.getChannels();
		Instrument [] instr = synth.getDefaultSoundbank().getInstruments();
		
		JFrame frame = new JFrame("Sound1");                
		JPanel pane = new JPanel();       
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		JButton button1 = new JButton("Kick"); 
		JButton button2 = new JButton("Snare"); 
		JButton button3 = new JButton("Cymbal"); 
		frame.getContentPane().add(pane);                   
		pane.add(button1); 
		pane.add(button2);
		pane.add(button3);
		
		KeyListener listener = (new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyChar() == 'a')
					mc[9].noteOn(35, 27);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		pane.addKeyListener(listener);
		pane.setFocusable(true);
		
		frame.pack();                                       
		frame.setVisible(true);   
		
		// Creating anonymous ActionListener to button1
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mc[9].noteOn(35, 27);				
			}
		});
		
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mc[9].noteOn(38, 17);				
			}
		});
		
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mc[9].noteOn(57, 17);				
			}
		});
		
//		ActionMap actionMap = pane.getActionMap();
//	      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
//	      InputMap inputMap = pane.getInputMap(condition);
		

	      
	      
		//System.exit(0);
		
		mc[10].allNotesOff();
	}	
}
