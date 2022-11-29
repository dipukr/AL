import java.awt.*;
import javax.swing.*;

public class Maze extends JPanel {

	private static final Color wallColor = new Color(39,40,34);
	private static final int gridSize = 30;
	private static final int margin = 50;
	
	private int[][] maze;
	private int rows;
	private int cols;
	
	public Maze(int[][] maze) {
		this.maze = maze;
		this.rows = maze.length;
		this.cols = maze[0].length;
		int W = gridSize * cols;
		int H = gridSize * rows;
		setVisible(true);
		setPreferredSize(new Dimension(W+margin, H+margin));
	}

	public boolean isValid(int r, int c) {
		if (r >= 0 && r < rows && c >= 0 && c < cols)
			return maze[r][c] == 1;
		return false;
	}

	public boolean hasPath(int r, int c) {
		if (isValid(r, c)) {
			if (r == rows-1 && c == cols-1)
				return true;
			maze[r][c] = 2;
			if (hasPath(r, c - 1)) return true;
			if (hasPath(r, c + 1)) return true;
			if (hasPath(r - 1, c)) return true;
			if (hasPath(r + 1, c)) return true;
			maze[r][c] = 1;
		}
		return false;
	}

	public int rowCount() {return rows;}
	public int colCount() {return cols;}
	
	public String toString() {
		var buf = new StringBuffer();
		for (int i = 0; i < rows; i++) {
			buf.append('[');
			for (int j = 0; j < cols; j++) {
				if (maze[i][j] == 0)
					buf.append('@');
				else if (maze[i][j] == 2)
					buf.append('*');
				else buf.append(' ');
			}
			buf.append("]\n");
		}
		return buf.toString();
	}

	public void paint(Graphics g) {
		var gc = (Graphics2D) g;
		for (int i = 0; i < cols; i++)
			for (int j = 0; j < rows; j++) {
				if (maze[j][i] == 0) {
					gc.setColor(wallColor);
					gc.fillRect(i*gridSize+margin/2, j*gridSize+margin/2, gridSize, gridSize);
				} else if (maze[j][i] == 2) {
					gc.setColor(Color.red);
					gc.fillRect(i*gridSize+margin/2, j*gridSize+margin/2, gridSize, gridSize);
				}
				gc.setColor(Color.black);
				gc.drawRect(i*gridSize+margin/2, j*gridSize+margin/2, gridSize, gridSize);
			}
	}

	public static void main(String[] args) throws Exception {
		int data[][] = {
			{1,1,0,1,0,0,0,0,0,0},
			{0,1,0,1,1,1,1,1,1,1},
			{0,1,0,0,0,0,0,1,0,1},
			{0,1,1,1,1,1,0,1,1,0},
			{0,0,0,0,0,1,0,1,1,1},
			{1,1,1,1,1,1,0,0,0,0},
			{1,1,1,0,1,1,1,1,1,0},
			{1,0,0,0,0,0,0,1,1,0},
			{1,1,1,1,1,1,0,0,0,0},
			{0,0,0,0,0,1,1,1,1,1}
		};
		int datab[][] = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,0},
			{0,1,0,1,1,1,0,1,0,0,0,1,0,0,0,1,0},
			{0,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,0},
			{0,1,0,1,1,1,1,1,0,0,0,1,0,0,0,1,0},
			{0,1,0,1,0,0,0,1,0,1,1,1,1,0,1,1,0},
			{0,1,0,1,0,1,1,1,0,0,0,1,1,1,1,1,0},
			{0,1,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0},
			{0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		};
		int datac[][] = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0},
			{0,1,1,1,0,1,1,1,0,0,0,0,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0},
			{0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0},
			{0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0},
			{0,1,1,1,0,1,1,1,0,0,0,0,0,1,1,1,0,1,1,1,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,0},
			{0,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0},
			{0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,1,1,1,0,1,1,1,0,1,1,1,0},
			{0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0},
			{0,0,0,0,0,1,1,1,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0},
			{0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,1,1,0,0,0,0,0,1,1,1,0,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,0,0,0,0,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		};
		var frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		var maze = new Maze(datac);
		maze.hasPath(0,0); // (2,9)
		
		frame.add(maze, BorderLayout.CENTER);
		frame.pack();
	}
}