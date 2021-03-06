package devices.servers.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import platform.gui.MainFrame;
import devices.Device;
import devices.servers.Server;
import devices.interfaces.Interface;
import devices.ui.DeviceUI;


public class ServerUI extends DeviceUI implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6867805375146846925L;
	Server serverName;
    
    public ServerUI(Server server) {
        super(server);
        serverName= server;
        setPopupMenu(popupMenu);
        initializePopupMenu();
        configure.addActionListener(this);
        console.addActionListener(this);
        ping.addActionListener(this);
        ports.addActionListener(this);
        portScan.addActionListener(this);
        delete.addActionListener(this);
        properties.addActionListener(this);
        addConnection.addActionListener(this);
        removeConnection.addActionListener(this);
        

    }

    public void initializePopupMenu() {
        popupMenu.add(configure);
        popupMenu.add(console);
        popupMenu.add(ping);
        popupMenu.addSeparator();
        popupMenu.add(ports);
        popupMenu.add(portScan);
        popupMenu.addSeparator();
        popupMenu.add(addConnection);
        popupMenu.add(removeConnection);
        popupMenu.addSeparator();
        popupMenu.add(delete);
        popupMenu.addSeparator();
        popupMenu.add(properties);
    }

    public void setAddInterfaces() {
        MainFrame.SERVER_PORT_DIALOG.addOrRemove=1;
        MainFrame.SERVER_PORT_DIALOG.interfaceCount=0;
    	addInterfaces = device.getOpenedInterfaces();
        if (addInterfaces.length >= 0){
        	MainFrame.SERVER_PORT_DIALOG.interfaceCount=addInterfaces.length;
        	MainFrame.SERVER_PORT_DIALOG.setInterfaceArray();
            for (int i = 0; i < addInterfaces.length; i++) {
            	MainFrame.SERVER_PORT_DIALOG.setActiveServerInterface(addInterfaces[i], i);

            }
            MainFrame.SERVER_PORT_DIALOG.setLights();
        } else MainFrame.SERVER_PORT_DIALOG.interfaceCount=-1;
        
    }

    public void setRemoveInterfaces() {
    	MainFrame.SERVER_PORT_DIALOG.addOrRemove=-1;
    	MainFrame.SERVER_PORT_DIALOG.interfaceCount=0;
    	
        removeInterfaces = device.getClosedInterfaces();
        if (removeInterfaces.length >= 0){
	       	//System.out.println(removeInterfaces.length);
	        MainFrame.SERVER_PORT_DIALOG.interfaceCount=removeInterfaces.length;
	        MainFrame.SERVER_PORT_DIALOG.setInterfaceArray();
	        
	        for (int i = 0; i < removeInterfaces.length; i++) {
	        	MainFrame.SERVER_PORT_DIALOG.setActiveServerInterface(removeInterfaces[i], i);
	        }
	        MainFrame.SERVER_PORT_DIALOG.setLights();
        } else MainFrame.SERVER_PORT_DIALOG.interfaceCount = -1;
        
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (source.equals(configure)) {
            MainFrame.SERVER_CONFIG_DIALOG.setServer((Server) getDevice());
            MainFrame.SERVER_CONFIG_DIALOG.showCentered();
        } else if (source.equals(console)) {
            getDevice().getConsole().showCentered();
        } else if (source.equals(ping)) {
            MainFrame.SERVER_PING_DIALOG.setServer((Server) getDevice());
            MainFrame.SERVER_PING_DIALOG.showCentered();
        } else if (source.equals(ports)) {
            MainFrame.SERVER_CONFIGURE_PORT_DIALOG.setServer((Server) getDevice());
            MainFrame.SERVER_CONFIGURE_PORT_DIALOG.showCentered();
        } else if (source.equals(portScan)) {
            MainFrame.SERVER_PORT_SCAN_DIALOG.setServer((Server) getDevice());
            MainFrame.SERVER_PORT_SCAN_DIALOG.showCentered();
        } else if (source.equals(properties)) {
            MainFrame.SERVER_PROPERTY_DIALOG.setServer((Server) getDevice());
            MainFrame.SERVER_PROPERTY_DIALOG.showCentered();
        } else if (source.equals(delete)) {
            Device device = getDevice();
            Interface[] interfaces = device.getClosedInterfaces();

            for (int i = 0; i < interfaces.length; i++) {
                MainFrame.DESIGNER_PANEL.removeConnection(interfaces[i]);
            }

            for (int i = 0; i < Device.DEVICES.size(); i++) {
                if (device == (Device) Device.DEVICES.get(i)) {
                    Device.DEVICES.remove(i);
                    MainFrame.DESIGNER_PANEL.repaint();

                    break;
                }
            }
        } else if (source.equals(addConnection)) {
        	MainFrame.SERVER_PORT_DIALOG.hideAll();
        	this.setAddInterfaces();
        	MainFrame.SERVER_PORT_DIALOG.showCentered();

        } else if (source.equals(removeConnection)) {
        	MainFrame.SERVER_PORT_DIALOG.hideAll();
            this.setRemoveInterfaces();
        	MainFrame.SERVER_PORT_DIALOG.showCentered();
        }
    }
}
