package ai.nets.samj.communication.model;

import net.imglib2.RandomAccessibleInterval;

import java.io.IOException;

import ai.nets.samj.communication.PromptsToEfficientSamJ;
import ai.nets.samj.communication.PromptsToNetAdapter;
import ai.nets.samj.ui.SAMJLogger;

public class EfficientSAM implements SAMModel {
	private Boolean installed = false;
	public static final String FULL_NAME = "EfficientSAM";

	@Override
	public String getName() {
		return FULL_NAME;
	}

	@Override
	public String getDescription() {
		return "Bla bla Efficient SAM";
	}

	@Override
	public boolean isInstalled() {
		return installed;
	}

	@Override
	public PromptsToNetAdapter instantiate(final RandomAccessibleInterval<?> image, final SAMJLogger useThisLoggerForIt) {
		try {
			return new PromptsToEfficientSamJ(image,useThisLoggerForIt);
		} catch (IOException | InterruptedException | RuntimeException e) {
			useThisLoggerForIt.error(FULL_NAME + " experienced an error: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setInstalled(boolean installed) {
		this.installed = installed;		
	}
}