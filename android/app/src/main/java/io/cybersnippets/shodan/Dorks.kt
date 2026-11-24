package io.cybersnippets.shodan

/**
 * A single Shodan query drawn from the cheat-sheet (README.md).
 *
 * [description] explains what the query surfaces; [query] is the exact
 * Shodan search string that gets sent to the REST API.
 */
data class Dork(
    val title: String,
    val description: String,
    val query: String,
)

data class DorkCategory(
    val name: String,
    val dorks: List<Dork>,
)

/**
 * Every request type listed in the Shodan cheat-sheet, grouped by section.
 * These are the publicly documented Shodan search filters; the app simply
 * runs them against the Shodan REST API using the user's own API key.
 */
object DorkCatalog {

    val categories: List<DorkCategory> = listOf(
        DorkCategory(
            name = "Basic Filters",
            dorks = listOf(
                Dork("city", "Find devices in a particular city.", "city:\"Bangalore\""),
                Dork("country", "Find devices in a particular country.", "country:\"IN\""),
                Dork("geo", "Find devices by geographical coordinates.", "geo:\"56.913055,118.250862\""),
                Dork("hostname", "Find devices matching the hostname.", "server: \"gws\" hostname:\"google\""),
                Dork("net", "Find devices based on an IP address or /x CIDR.", "net:210.214.0.0/16"),
                Dork("os", "Find devices based on operating system.", "os:\"windows 7\""),
                Dork("port", "Find devices based on open ports.", "proftpd port:21"),
                Dork("before / after", "Find devices between a given time window.", "apache after:22/02/2009 before:14/3/2010"),
            )
        ),
        DorkCategory(
            name = "Exposed Services & Devices",
            dorks = listOf(
                Dork("Citrix", "Find Citrix Gateway.", "title:\"citrix gateway\""),
                Dork("Wifi Passwords", "Cleartext wifi passwords surfaced in Shodan.", "html:\"def_wirelesspassword\""),
                Dork("Surveillance Cams", "Surveillance cameras (uc-httpd).", "NETSurveillance uc-httpd"),
                Dork("Fuel Pumps", "Fuel pumps with a CLI terminal exposed.", "\"privileged command\" GET"),
                Dork("Windows RDP", "Windows RDP handshake banner.", "\"\\x03\\x00\\x00\\x0b\\x06\\xd0\\x00\\x00\\x124\\x00\""),
                Dork("MongoDB", "MongoDB servers exposing server information.", "\"MongoDB Server Information\" port:27017 -authentication"),
                Dork("FTP Anonymous (banner)", "FTP servers allowing anonymous access.", "\"220\" \"230 Login successful.\" port:21"),
                Dork("Jenkins", "Unrestricted Jenkins dashboards.", "x-jenkins 200"),
                Dork("Hacked Routers", "Routers that got compromised.", "hacked-router-help-sos"),
                Dork("Open ATM", "ATM availability (NCR, SNMP).", "NCR Port:\"161\""),
                Dork("Telnet Access", "Telnet gateways with no password.", "port:23 console gateway"),
                Dork("Misconfigured WordPress", "Exposed wp-config.php creation script.", "http.html:\"* The wp-config.php creation script uses this file\""),
                Dork("Hiring", "Sites advertising recruiting headers.", "\"X-Recruiting:\""),
                Dork("Android Debug Bridge", "Android root bridges on port 5555.", "\"Android Debug Bridge\" \"Device\" port:5555"),
                Dork("Ethereum Miners", "Miners running ETH.", "\"ETH - Total speed\""),
                Dork("Tesla PowerPack", "Charging status of Tesla PowerPacks.", "http.title:\"Tesla PowerPack System\" http.component:\"d3\" -ga3ca4f2"),
                Dork("Default Password", "Devices advertising a default password.", "\"default password\""),
                Dork("Windows RDP + Screenshots", "Windows servers with RDP and screenshots.", "os:windows port:3389 has_screenshot:yes"),
                Dork("MySQL in London", "MySQL servers in London, GB.", "country:gb city:london product:MySQL"),
                Dork("Google Expired SSL", "Google-owned hosts with expired SSL certs.", "org:google ssl.cert.expired:true"),
                Dork("Unprotected VNC", "VNC with authentication disabled.", "\"authentication disabled\" \"RFB 003.008\""),
                Dork("FTP Anonymous Login", "FTP anonymous login OK.", "anonymous@ login ok. port:\"21\""),
                Dork("SMB No Authentication", "SMB with authentication disabled.", "port:\"445\" Authentication: \"disabled\""),
                Dork("SMB No Auth — DC", "Domain controllers with SMB auth disabled.", "\"Authentication: disabled\" NETLOGON SYSVOL -unix port:445"),
                Dork("Cisco No Authentication", "Cisco devices advertising the cisco/cisco notice.", "\"This feature requires the one-time use of the username \\\"cisco\\\" with the password \\\"cisco\\\"\""),
                Dork("HP Printers", "HP printers via embedded HTTP server.", "\"Serial Number:\" \"Built:\" \"Server: HP HTTP\""),
                Dork("Xerox/Epson Printers (Linux UPnP)", "Epson Linux UPnP print servers.", "\"SERVER: EPSON_Linux UPnP\" \"200 OK\""),
                Dork("Xerox/Epson Printers (HTTP)", "Epson HTTP print servers.", "\"Server: EPSON-HTTP\" \"200 OK\""),
            )
        ),
        DorkCategory(
            name = "Device Types",
            dorks = listOf(
                Dork("Firewall", "device:firewall", "device:firewall"),
                Dork("Router", "device:router", "device:router"),
                Dork("WAP", "device:wap", "device:wap"),
                Dork("Webcam", "device:webcam", "device:webcam"),
                Dork("Media", "device:media", "device:media"),
                Dork("Broadband Router", "device:\"broadband router\"", "device:\"broadband router\""),
                Dork("PBX", "device:pbx", "device:pbx"),
                Dork("Printer", "device:printer", "device:printer"),
                Dork("Switch", "device:switch", "device:switch"),
                Dork("Storage", "device:storage", "device:storage"),
                Dork("Specialized", "device:specialized", "device:specialized"),
                Dork("Phone", "device:phone", "device:phone"),
                Dork("VoIP", "device:\"voip\"", "device:\"voip\""),
                Dork("VoIP Phone", "device:\"voip phone\"", "device:\"voip phone\""),
                Dork("VoIP Adaptor", "device:\"voip adaptor\"", "device:\"voip adaptor\""),
                Dork("Load Balancer", "device:\"load balancer\"", "device:\"load balancer\""),
                Dork("Print Server", "device:\"print server\"", "device:\"print server\""),
                Dork("Terminal", "device:terminal", "device:terminal"),
                Dork("Remote", "device:remote", "device:remote"),
                Dork("Telecom", "device:telecom", "device:telecom"),
                Dork("Power", "device:power", "device:power"),
                Dork("Proxy", "device:proxy", "device:proxy"),
                Dork("PDA", "device:pda", "device:pda"),
                Dork("Bridge", "device:bridge", "device:bridge"),
            )
        ),
        DorkCategory(
            name = "Industrial Control Systems",
            dorks = listOf(
                Dork("Samsung Billboards", "Samsung electronic billboards.", "\"Samsung\" \"LED\" billboard"),
                Dork("Gas Pumps", "Gas station pump controllers.", "\"fuel pump\" port:23 OR port:502"),
                Dork("License Plate Readers", "Automatic license plate readers.", "ALPR camera"),
                Dork("Traffic Lights", "Traffic light and red light camera systems.", "traffic light controller"),
                Dork("Voting Machines", "Voting machines in the United States.", "voting machine"),
                Dork("Cisco Wiretap", "Cisco lawful intercept wiretaps.", "Cisco intercept"),
                Dork("Prison Pay Phones", "Prison facility pay phones.", "prison call management"),
                Dork("Tesla PowerPack", "Tesla PowerPack battery charging status.", "tesla powerpack"),
                Dork("EV Chargers", "Electric vehicle charging stations.", "\"charging station\" OR \"ev charger\""),
                Dork("Maritime Satellites", "Maritime satellite communication systems.", "maritime satellite"),
                Dork("Submarine Control", "Submarine mission control dashboards.", "submarine sonar"),
                Dork("CAREL Refrigeration", "CAREL PlantVisor refrigeration units.", "CAREL plantvisor"),
                Dork("Nordex Turbines", "Nordex wind turbine farm systems.", "Nordex windmill"),
                Dork("C4 Vehicle Trackers", "C4 Max commercial vehicle GPS trackers.", "C4 Max GPS"),
                Dork("DICOM X-Ray", "DICOM medical X-ray machine systems.", "DICOM xray"),
                Dork("GaugeTech Meters", "GaugeTech electricity meter systems.", "GaugeTech meter"),
                Dork("Siemens Industrial", "Siemens industrial automation systems.", "Siemens automation"),
                Dork("Siemens HVAC", "Siemens HVAC building control systems.", "Siemens HVAC"),
                Dork("Door/Lock Control", "Door and lock access control systems.", "access control door"),
                Dork("Railroad Mgmt", "Railroad management and signaling systems.", "railroad signal"),
            )
        ),
        DorkCategory(
            name = "Remote Desktop",
            dorks = listOf(
                Dork("Unprotected VNC", "VNC with authentication disabled.", "\"authentication disabled\" \"RFB 003\""),
                Dork("Windows RDP", "Windows RDP accessible systems.", "port:3389 os:windows"),
            )
        ),
        DorkCategory(
            name = "Network Infrastructure",
            dorks = listOf(
                Dork("Weave Scope", "Weave container management dashboards.", "weave scope"),
                Dork("MongoDB Exposed", "MongoDB instances without authentication.", "mongodb -authentication"),
                Dork("Mongo Express", "Mongo Express web interface exposed.", "mongo-express"),
                Dork("Jenkins Exposed", "Unrestricted Jenkins CI dashboards.", "jenkins"),
                Dork("Docker API", "Docker API endpoints exposed.", "Docker API port:2375"),
                Dork("Docker Registry", "Docker private registry access.", "docker registry"),
                Dork("Pi-hole DNS", "Pi-hole open DNS servers.", "pi-hole"),
                Dork("Telnet Root", "Already logged in as root via Telnet.", "port:23 login"),
                Dork("Android Bridges", "Android root bridges on port 5555.", "\"Android Debug Bridge\" port:5555"),
                Dork("Lantronix Adapter", "Lantronix serial-to-ethernet leaking passwords.", "lantronix"),
                Dork("Citrix Gateway", "Citrix virtual apps and desktops.", "citrix gateway"),
                Dork("Cisco Smart Install", "Cisco Smart Install protocol exposed.", "cisco smart install"),
                Dork("PBX Gateways", "IP PBX phone gateway systems.", "pbx gateway"),
                Dork("Polycom Video", "Polycom video conferencing systems.", "polycom"),
                Dork("Bomgar Help Desk", "Bomgar remote support portal access.", "bomgar"),
                Dork("Intel AMT CVE-2017-5689", "Intel Active Management vulnerable.", "Intel-AMT"),
                Dork("HP iLO 4 CVE-2017-12542", "HP iLO 4 vulnerable systems.", "hp ilo 4"),
                Dork("Exchange OWA", "Outlook Web Access exposed.", "outlook web access"),
                Dork("Lync/Skype", "Skype for Business/Lync servers.", "skype for business"),
            )
        ),
        DorkCategory(
            name = "Network Attached Storage",
            dorks = listOf(
                Dork("SMB Shares", "SMB file shares with open access.", "port:445 smb"),
                Dork("Anonymous FTP", "FTP servers with anonymous login.", "\"220\" \"230 Login successful\" port:21"),
                Dork("Iomega/LenovoEMC NAS", "Iomega and LenovoEMC NAS devices.", "iomega nas"),
                Dork("Buffalo TeraStation", "Buffalo TeraStation NAS systems.", "buffalo terastation"),
                Dork("Logitech Media", "Logitech media server instances.", "logitech media"),
                Dork("Plex Media Server", "Plex media server instances.", "plex media server"),
                Dork("Tautulli/PlexPy", "Tautulli Plex monitoring dashboards.", "tautulli"),
            )
        ),
        DorkCategory(
            name = "Webcams & Video",
            dorks = listOf(
                Dork("Yawcam", "Yawcam live stream webcams.", "yawcam"),
                Dork("WebcamXP/7", "WebcamXP and webcam7 systems.", "webcamxp"),
                Dork("Android IP Webcam", "Android IP camera server.", "\"Android IP Webcam\""),
                Dork("Security DVR", "Security DVR recording systems.", "dvr security"),
            )
        ),
        DorkCategory(
            name = "Printers & Copiers",
            dorks = listOf(
                Dork("HP Printers", "HP network printers.", "\"server: hp http\" port:80"),
                Dork("Xerox Copiers", "Xerox network copiers and multifunction devices.", "xerox"),
                Dork("Epson Printers", "Epson network printers.", "\"server: epson\" port:80"),
                Dork("Canon Printers", "Canon network printers and multifunction devices.", "canon printer"),
            )
        ),
        DorkCategory(
            name = "Home & Smart Devices",
            dorks = listOf(
                Dork("Yamaha Stereos", "Yamaha networked stereo systems.", "yamaha"),
                Dork("AirPlay Receivers", "Apple AirPlay audio receivers.", "airplay"),
                Dork("Chromecast/Smart TV", "Chromecast and smart TV devices.", "chromecast OR \"smart tv\""),
                Dork("Crestron Home", "Crestron smart home control systems.", "crestron"),
            )
        ),
        DorkCategory(
            name = "Miscellaneous",
            dorks = listOf(
                Dork("OctoPrint 3D", "OctoPrint 3D printer control panels.", "octoprint"),
                Dork("Ethereum Miners", "Ethereum mining pool connections.", "\"ETH\" miner"),
                Dork("Apache Directory", "Apache servers with directory listing.", "\"Index of /\" apache"),
                Dork("Misconfigured WP", "WordPress with exposed configuration.", "wp-config.php"),
                Dork("Minecraft Servers", "Minecraft multiplayer servers.", "minecraft server"),
                Dork("North Korea", "Everything indexed in North Korea.", "country:kp"),
                Dork("Quote of Day", "TCP Quote of the Day service.", "port:17 \"Quote of the Day\""),
            )
        ),
    )

    /** Flat list of every dork, used for the search index. */
    val all: List<Dork> = categories.flatMap { it.dorks }
}
