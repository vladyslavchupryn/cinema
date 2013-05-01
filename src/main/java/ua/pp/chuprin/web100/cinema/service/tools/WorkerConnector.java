package ua.pp.chuprin.web100.cinema.service.tools;

import java.io.IOException;
import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.pp.chuprin.web100.cinema.domain.worker.Worker;

public class WorkerConnector implements AutoCloseable {
	private static final String CHANEL_TYPE = "exec";

	private static final String STOP_COMMAND = "stop";

	private static final String START_COMMAND = "start";

	private static final String STATUS_COMMAND = "status";

	private static final String SUCCESS_RESPONSE = "OK";

	private static final Logger LOG = LoggerFactory.getLogger(WorkerConnector.class);

	private static final String PASSWORD = "";

	private static final int PORT = 22;

	private static final String USER = "";

	private Session connection;

	public WorkerConnector(Worker worker) throws IOException {
		JSch channel = new JSch();
		try {
			connection = channel.getSession(USER, worker.getIp(), PORT);
			connection.setPassword(PASSWORD);
			// UNCOMMENT THIS FOR TESTING PURPOSES, BUT DO NOT USE IN PRODUCTION
			// connection.setConfig("StrictHostKeyChecking", "no");
			connection.connect();
		} catch (JSchException e) {
			throw new IOException("Jsr error", e);
		}
	}

	@Override
	public void close() {
		if (connection != null && connection.isConnected()) {
			connection.disconnect();
		}
	}

	public String execCommand(String command) throws IOException {
		StringBuilder outputBuffer = new StringBuilder();

		Channel channel = null;
		try {
			channel = connection.openChannel(CHANEL_TYPE);

			((ChannelExec) channel).setCommand(command);
			channel.connect();

			InputStream outputStream = channel.getInputStream();
			int readByte = outputStream.read();

			while (readByte != 0xffffffff) {
				outputBuffer.append((char) readByte);
				readByte = outputStream.read();
			}
		} catch (JSchException e) {
			throw new IOException("Jsr error", e);
		} finally {
			if (channel != null) {
				channel.disconnect();
			}
		}

		return outputBuffer.toString();
	}

	public boolean start() throws IOException {
		return successCommand(START_COMMAND);
	}

	public String status() throws IOException {
		return execCommand(STATUS_COMMAND);
	}

	public boolean successCommand(String command) throws IOException {
		String result = execCommand(command);
		if (result.equals(SUCCESS_RESPONSE)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean stop() throws IOException {
		return successCommand(STOP_COMMAND);
	}
}
