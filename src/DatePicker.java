import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatePicker {
    int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    JLabel l = new JLabel("", JLabel.RIGHT);
    String day = "";
    JDialog d;
    JButton[] button = new JButton[49];

    public DatePicker(JPanel parent) {
        d = new JDialog();
        d.setModal(true);
        String[] header = { "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" };
        float BTN_SIZE = 11f;
        JPanel p1 = new JPanel(new GridLayout(7, 7));

        for (int x = 0; x < button.length; x++) {
            final int selection = x;
            button[x] = new JButton();
            button[x].setFont(button[x].getFont().deriveFont(Font.BOLD, BTN_SIZE));
            button[x].setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
            button[x].setBackground(Color.WHITE);
            if (x > 6) {
                button[x].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        day = button[selection].getActionCommand();
                        d.dispose();
                    }
                });
            }
            if (x < 7) {
                button[x].setText(header[x]);
                button[x].setForeground(Color.red);
            }
            p1.add(button[x]);
        }
        JPanel p2 = new JPanel();
        p2.setBackground(Color.WHITE);

        // Last year button
        JButton lastYear = new JButton("<<");
        lastYear.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        lastYear.setBackground(Color.WHITE);
        lastYear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                year--;
                displayDate();
            }
        });
        p2.add(lastYear);

        // Previous month button
        JButton previous = new JButton("<");
        previous.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        previous.setBackground(Color.WHITE);
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                month--;
                displayDate();
            }
        });
        p2.add(previous);

        // Selected Date @ popup
        p2.add(l);

        // Next month button
        JButton next = new JButton(">");
        next.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        next.setBackground(Color.WHITE);
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                month++;
                displayDate();
            }
        });
        p2.add(next);

        // Next year button
        JButton nextYear = new JButton(">>");
        nextYear.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        nextYear.setBackground(Color.WHITE);
        nextYear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                year++;
                displayDate();
            }
        });
        p2.add(nextYear);

        d.add(p1, BorderLayout.CENTER);
        d.add(p2, BorderLayout.NORTH);
        d.pack();
        d.setLocationRelativeTo(parent);
        displayDate();
        d.setVisible(true);
    }

    public void displayDate() {
        for (int x = 7; x < button.length; x++) {
            button[x].setText("");
        }

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, 1);
        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

        for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++) {
            button[x].setText("" + day);
        }

        l.setText(sdf.format(cal.getTime()));
        d.setTitle("Date Picker");
    }

    public String setPickedDate() {
        if (day.equals("")) {
            return day;
        }

        // Set the return date format
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, Integer.parseInt(day));
        return sdf.format(cal.getTime());
    }
}