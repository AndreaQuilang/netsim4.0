package devices.interfaces;

import devices.*;


public class Ethernet extends Interface {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -1150109178230480638L;
	private final String description = "\n   Hardware is Lance, address is 000C.3782.8690 (bia 000C.3782.8690)\n   MTU 1500 bytes, BW 10000 Kbit, DLY 1000 usec, rely 255/255, load 1/255\n   Encapsulation ARPA, loopback not set, keepalive set (10 sec)\n   ARP type: ARPA, ARP Timeout 04:00:00\n   Last input 00:00:00, output 00:00:00, output hang never\n   Last clearing of \"show interface\" counters never\n   Queueing strategy: fifo\n   Output queue 0/40, 0 drops; input queue 0/75, 0 drops\n   5 minute input rate 1000 bits/sec, 2 packets/sec\n   5 minute output rate 1000 bits/sec, 2 packets/sec\n      0 packets input, 0 bytes, 0 no buffer\n      Received 0 broadcasts, 0 runts, 0 giants, 0 throttles\n      0 input errors, 0 CRC, 0 frame, 0 overrun, 0 ignored, 0 abort\n      0 input packets with dribble condition detected\n      0 packets output, 0 bytes, 0 underruns\n      0 output errors, 0 collisions, 0 interface resets\n      0 babbles, 0 late collision, 0 deferred\n      0 lost carrier, 0 no carrier\n      0 output buffer failures, 0 output buffers swapped out";

    public Ethernet(Device device, String name, String consoleName) {
        super(device, name, consoleName);
    }

    public String getDescription() {
        return description;
    }
}
