import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Main 
{	
	private KeyHandler keyHandler;
	private RenderEngine renderEngine;
	private CanvasManager display;
	private boolean running;
	
	public static void main(String[] args)
	{
		new Main();
	}
	
	public Main()
	{
		this.keyHandler = new KeyHandler();
		this.display = new CanvasManager();
		
		JFrame frame = new JFrame("Title of my game");
		Dimension dimension = new Dimension(CanvasManager.WIDTH, CanvasManager.HEIGHT);
		frame.setMinimumSize(dimension);
		frame.setPreferredSize(dimension);
		frame.setMaximumSize(dimension);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this.keyHandler);
		frame.add(this.display);
		frame.pack();
		frame.setVisible(true);
		
		
		BufferStrategy bufferStrategy = this.display.getBufferStrategy();
		
		if(bufferStrategy == null)
		{
			this.display.createBufferStrategy(3);
			bufferStrategy = this.display.getBufferStrategy();
		}
		
		this.renderEngine = new RenderEngine(bufferStrategy);
		
		Thread thread = new Thread(() -> run());
		thread.start();
	}
	
	public void run()
	{
		this.running = true;
		
		while(running)
		{
			this.tick();
			this.renderEngine.render();	
		}
	}
	
	public void tick()
	{
		
	}
}
