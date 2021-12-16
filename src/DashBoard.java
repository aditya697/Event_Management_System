import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class DashBoard extends JFrame implements ActionListener {
    JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);;
    ViewUsers viewUsers = new ViewUsers(tabs);
    Capacity capacity = new Capacity(tabs);
    OldEvents oldEvents = new OldEvents(tabs);
    DeleteUsers deleteUsers = new DeleteUsers();
    UpComingEvents upcoming = new UpComingEvents();
    EventDetails eventDetails = new EventDetails(tabs);
    CurrentEvents currentEvents = new CurrentEvents(tabs);
    RegistrationDetails registrationDetails = new RegistrationDetails();
    ViewProfile viewProfile = new ViewProfile();
    EditProfile editProfile = new EditProfile();

    public static void main(String[] args) {
        new DashBoard().setVisible(true);
    }

    public DashBoard() {
        super("DashBoard");
        setBounds(50, 50, 890, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon HomeIcon = new ImageIcon("icons/Home_Icon.png");
        ImageIcon AddEventIcon = new ImageIcon("icons/Add_Event_Icon.png");
        ImageIcon ViewUserIcon = new ImageIcon("icons/View_Users_Icon.png");
        ImageIcon CapacityIcon = new ImageIcon("icons/Capacity_Icon.png");
        ImageIcon OldEventIcon = new ImageIcon("icons/Old_Events_Icon.png");
        ImageIcon DeleteUserIcon = new ImageIcon("icons/Delete_User_Icon.png");
        ImageIcon UpcomingIcon = new ImageIcon("icons/Upcoming_Events_Icon.png");
        ImageIcon EventDetailsIcon = new ImageIcon("icons/Event_Details_Icon.png");
        ImageIcon CurrentEventsIcon = new ImageIcon("icons/Current_Events_Icon.png");
        ImageIcon RegistrationDetailsIcon = new ImageIcon("icons/Registration_Icon.png");
        ImageIcon ViewProfileIcon = new ImageIcon("icons/View_Profile_Icon.png");
        ImageIcon EditProfileIcon = new ImageIcon("icons/Edit_Profile_Icon.png");

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(Box.createRigidArea(new Dimension(15, 100)));
        menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 136, 64), new Color(128, 128, 128)));
        menuBar.setBackground(new Color(245, 136, 64));
        menuBar.setBounds(797, 0, 70, 28);
        add(menuBar);

        JMenu mnExit = new JMenu("Exit");
        mnExit.setFont(new Font("Comic Sans MS", Font.BOLD, 17));

        JMenuItem mntmLogout = new JMenuItem("Logout");
        mntmLogout.setBackground(Color.white);
        mntmLogout.setForeground(Color.red);
        mntmLogout.addActionListener(this);
        mnExit.add(mntmLogout);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.setForeground(Color.red);
        mntmExit.setBackground(Color.white);
        mntmExit.addActionListener(this);
        mnExit.add(mntmExit);

        menuBar.add(mnExit);

        tabs.addTab("Home", HomeIcon, new Home());
        if (Objects.equals(LoggedInUser.getUser().getUsername(), "Admin")) {
            tabs.addTab("Add Event", AddEventIcon, new AddEvent());
            tabs.addTab("View Users", ViewUserIcon, viewUsers);
            tabs.addTab("Capacity", CapacityIcon, capacity);
            tabs.addTab("Old Events", OldEventIcon, oldEvents);
            tabs.addTab("Delete Users", DeleteUserIcon, deleteUsers);
        }
        tabs.addTab("Upcoming Events", UpcomingIcon, upcoming);
        tabs.addTab("Event Details", EventDetailsIcon, eventDetails);
        tabs.addTab("Current Events", CurrentEventsIcon, currentEvents);
        tabs.addTab("Registration Details", RegistrationDetailsIcon, registrationDetails);
        tabs.addTab("View Profile", ViewProfileIcon, viewProfile);
        tabs.addTab("Edit Profile", EditProfileIcon, editProfile);
        tabs.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        tabs.setBackground(new Color(255, 206, 69));
        add(tabs);

        tabs.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if(Objects.equals(LoggedInUser.getUser().getUsername(), "Admin")){
                switch (tabs.getSelectedIndex()) {
                    case 2:
                        viewUsers.display_events();
                    case 3:
                        capacity.display_events();
                    case 4:
                        oldEvents.display_events();
                    case 5:
                        deleteUsers.display_events();
                    case 6:
                        upcoming.display_events();
                    case 7:
                        eventDetails.display_events();
                    case 8:
                        currentEvents.display_events();
                    case 9:
                        registrationDetails.display_events();
                    case 10:
                        viewProfile.displayProfile();
                    case 11:
                        editProfile.displayProfile();
                    }
                }
                else {
                    switch (tabs.getSelectedIndex()){
                        case 1 :
                            upcoming.display_events();
                        case 2 :
                            eventDetails.display_events();
                        case 3 :
                            currentEvents.display_events();
                        case 4 :
                            registrationDetails.display_events();
                        case 5 :
                            viewProfile.displayProfile();
                        case 6 :
                            editProfile.displayProfile();
                    }
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        switch (msg) {
            case "Logout" -> {
                setVisible(false);
                new LoginUser().setVisible(true);
            }
            case "Exit" -> System.exit(ABORT);
        }
    }
}
