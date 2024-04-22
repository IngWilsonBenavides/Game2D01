package com.w1ll1x.ld22.level.levelgen;

import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class NoiseMap {

	public double[] values;
	private int w, h;

	public NoiseMap(int w, int h) {
		this.w = w;
		this.h = h;

		values = new double[w * h];

		Random random = new Random();

		int stepSize = w;
		do {
			int halfStep = stepSize / 2;
			for (int y = 0; y < w; y += stepSize) {
				for (int x = 0; x < w; x += stepSize) {
					double a = sample(x, y);
					double b = sample(x + stepSize, y);
					double c = sample(x, y + stepSize);
					double d = sample(x + stepSize, y + stepSize);
					double scale = 1.0 / w;
	
					double e = (a + b + c + d) / 4.0 + (random.nextFloat() * 2 - 1) * stepSize * scale;
					setSample(x + halfStep, y + halfStep, e);
				}
			}
			for (int y = 0; y < w; y += stepSize) {
				for (int x = 0; x < w; x += stepSize) {
					double a = sample(x, y);
					double b = sample(x + stepSize, y);
					double c = sample(x, y + stepSize);
					double d = sample(x + halfStep, y + halfStep);
					double e = sample(x + halfStep, y - halfStep);
					double f = sample(x - halfStep, y + halfStep);
					double scale = 1.0 / w;
					
					double H = (a + b + d + e) / 4.0 + (random.nextFloat() * 2 - 1) * stepSize * scale;
					double g = (a + b + c + f) / 4.0 + (random.nextFloat() * 2 - 1) * stepSize * scale;
					setSample(x + halfStep, y, H);
					setSample(x, y + halfStep, g);
				}
			}
			stepSize /= 2;
		} while( stepSize > 1);
	}

	private double sample(int x, int y) {
		return values[(x & (w - 1)) + (y & (h - 1)) * w];
	}
	
	private void setSample(int x, int y, double value) {
		values[(x & (w - 1)) + (y & (h - 1)) * w] = value;
	}
	
	public static void main(String[] args) {
		int w = 256;
		int h = 256;
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		JOptionPane.showMessageDialog(null, null, "The image", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(img));
	}
}