package tv.codely.utils;

import tv.codely.models.*;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class MainScreenGUI extends JFrame {

    private final JPanel contentPanel;
    private final Color mainBackgroundColor = new Color(70, 130, 180);


    public MainScreenGUI() {
        // Set up the frame
        setTitle("Healthcare Management System");
        setSize(850, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header with background color
        JLabel headerLabel = new JLabel("Healthcare Management System", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        headerLabel.setOpaque(true);  // Allows background color to be set
        headerLabel.setBackground(mainBackgroundColor);  // Set your preferred background color
        headerLabel.setForeground(Color.WHITE);  // Set the text color to white
        add(headerLabel, BorderLayout.NORTH);

        // Navigation panel with buttons
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new GridLayout(4, 1, 10, 10));
        navPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        navPanel.setBackground(mainBackgroundColor);

        JButton doctorOperationsBtn = new JButton("Doctor Operations");
        JButton patientOperationsBtn = new JButton("Patient Operations");
        JButton appointmentsBtn = new JButton("Appointments");
        JButton exitBtn = new JButton("Exit...");

        navPanel.add(doctorOperationsBtn);
        navPanel.add(patientOperationsBtn);
        navPanel.add(appointmentsBtn);
        navPanel.add(exitBtn);

        add(navPanel, BorderLayout.WEST);

        // Content panel where the functionality will be displayed
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(contentPanel, BorderLayout.CENTER);

        // Footer with background color
        JLabel footerLabel = new JLabel("Made with love in Egypt \uD83D\uDC99", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        footerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        footerLabel.setOpaque(true);
        footerLabel.setBackground(mainBackgroundColor);  // Light gray background
        footerLabel.setForeground(Color.WHITE);  // Dark gray text color
        add(footerLabel, BorderLayout.SOUTH);

        // Button actions
        doctorOperationsBtn.addActionListener(e -> showDoctorOperations());

        patientOperationsBtn.addActionListener(e -> showPatientOperations());

        appointmentsBtn.addActionListener(e -> showAppointments());

        exitBtn.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to exit?",
                "Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        // Make the frame visible
        setVisible(true);
    }

    //TODO == DOCTOR ==  TODO TODO TODO TODO TODO TODO TODO TODO TODO
    private void showDoctorOperations() {
        contentPanel.removeAll();

        // Header for the section
        JLabel header = new JLabel("Doctor Operations", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Add space below the header
        contentPanel.add(header, BorderLayout.NORTH);

        // Panel for doctor operation buttons
        JPanel doctorPanel = new JPanel();
        doctorPanel.setLayout(new GridLayout(4, 1, 10, 10)); // 4 buttons in 1 column
        doctorPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Add padding around the buttons

        // Add Doctor button
        JButton addDoctorBtn = new JButton("Add New Doctor");
        styleButton(addDoctorBtn); // Apply styling
        addDoctorBtn.addActionListener(e -> addDoctor()); // Link to action method
        doctorPanel.add(addDoctorBtn);

        // Edit Doctor button
        JButton editDoctorBtn = new JButton("Edit Doctor");
        styleButton(editDoctorBtn);
        editDoctorBtn.addActionListener(e -> editDoctor());
        doctorPanel.add(editDoctorBtn);

        // Display Doctors button
        JButton displayDoctorsBtn = new JButton("Display All Doctors");
        styleButton(displayDoctorsBtn);
        displayDoctorsBtn.addActionListener(e -> displayDoctors());
        doctorPanel.add(displayDoctorsBtn);

        // Delete Doctor button
        JButton deleteDoctorBtn = new JButton("Delete Doctor");
        styleButton(deleteDoctorBtn);
        deleteDoctorBtn.addActionListener(e -> deleteDoctor());
        doctorPanel.add(deleteDoctorBtn);

        // Add the doctorPanel to the contentPanel
        contentPanel.add(doctorPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void addDoctor() {
        contentPanel.removeAll();

        // Create a panel for the form layout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Header label
        JLabel headerLabel = new JLabel("Add New Doctor...", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(mainBackgroundColor);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(headerLabel, gbc);

        // Reset gridwidth and anchor for the other components
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Create and add labels and text fields
        JLabel[] labels = new JLabel[5];
        JTextField[] textFields = new JTextField[5];
        String[] labelTexts = {"ID:", "Name:", "Address:", "Phone:", "Specialty"};

        for (int i = 0; i < 5; i++) {
            labels[i] = new JLabel(labelTexts[i]);
            textFields[i] = new JTextField(20);

            gbc.gridx = 0;
            gbc.gridy = i + 1;  // Start below the header
            formPanel.add(labels[i], gbc);

            gbc.gridx = 1;
            formPanel.add(textFields[i], gbc);
        }

        // TODO Create and add radio buttons
//        JLabel ratioLabel = new JLabel("Choose one:");
//        gbc.gridx = 0;
//        gbc.gridy = 6;
//        formPanel.add(ratioLabel, gbc);
//
//        JRadioButton option1 = new JRadioButton("Option 1");
//        JRadioButton option2 = new JRadioButton("Option 2");
//        ButtonGroup group = new ButtonGroup();
//        group.add(option1);
//        group.add(option2);
//
//        JPanel radioPanel = new JPanel();
//        radioPanel.add(option1);
//        radioPanel.add(option2);
//
//        gbc.gridx = 1;
//        formPanel.add(radioPanel, gbc);

        // Create and add the submit button
        JButton submitButton = new JButton("Add Doctor");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitButton, gbc);

        // Action listener for the submit button
        submitButton.addActionListener(e -> {
            boolean allFieldsFilled = true;

            for (JTextField textField : textFields) {
                String text = textField.getText().trim();
                if (text.isEmpty()) {
                    textField.setBackground(Color.RED);
                    allFieldsFilled = false;
                } else {
                    textField.setBackground(Color.WHITE);
                }
            }

            if (allFieldsFilled) {
                //TODO Saving Data
                HealthcareSystem system = HealthcareSystem.getInstance();
                system.addDoctor(new Doctor(textFields[0].getText().trim(), textFields[1].getText().trim(), textFields[2].getText().trim(), textFields[3].getText().trim(), textFields[4].getText().trim()));


                JOptionPane.showMessageDialog(this, "Doctor added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add the form panel to the content panel
        contentPanel.add(formPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void editDoctor() {
        contentPanel.removeAll();

        // Create a panel for the form layout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Header label
        JLabel headerLabel = new JLabel("Edit Doctor Information", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(mainBackgroundColor);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(headerLabel, gbc);

        // Reset gridwidth and anchor for the other components
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Search field for Doctor ID
        JLabel searchLabel = new JLabel("Enter Doctor ID:");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(searchLabel, gbc);

        gbc.gridx = 1;
        formPanel.add(searchField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(searchButton, gbc);

        // Action listener for the search button
        searchButton.addActionListener(e -> {
            String id = searchField.getText().trim();
            HealthcareSystem system = HealthcareSystem.getInstance();
            Doctor doctor = system.getDoctorById(id);

            if (doctor != null) {
                // Clear the panel for the next form
                formPanel.removeAll();

                // Reuse GridBagConstraints
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.CENTER;

                // Header label
                formPanel.add(headerLabel, gbc);

                // Reset gridwidth and anchor for the other components
                gbc.gridwidth = 1;
                gbc.anchor = GridBagConstraints.WEST;

                // Create and add labels and text fields for editing
                JLabel[] labels = new JLabel[4];
                JTextField[] textFields = new JTextField[4];
                String[] labelTexts = {"Name:", "Address:", "Phone:", "Specialty"};
                String[] doctorData = {doctor.getName(), doctor.getAddress(), doctor.getPhoneNumber(), doctor.getSpecialty()};

                for (int i = 0; i < 4; i++) {
                    labels[i] = new JLabel(labelTexts[i]);
                    textFields[i] = new JTextField(20);
                    textFields[i].setText(doctorData[i]);

                    gbc.gridx = 0;
                    gbc.gridy = i + 1;  // Start below the header
                    formPanel.add(labels[i], gbc);

                    gbc.gridx = 1;
                    formPanel.add(textFields[i], gbc);
                }

                // Create and add the submit button
                JButton submitButton = new JButton("Update Doctor");
                gbc.gridx = 0;
                gbc.gridy = 5;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.CENTER;
                formPanel.add(submitButton, gbc);

                // Action listener for the submit button
                submitButton.addActionListener(e1 -> {
                    boolean allFieldsFilled = true;

                    for (JTextField textField : textFields) {
                        String text = textField.getText().trim();
                        if (text.isEmpty()) {
                            textField.setBackground(Color.RED);
                            allFieldsFilled = false;
                        } else {
                            textField.setBackground(Color.WHITE);
                        }
                    }

                    if (allFieldsFilled) {
                        doctor.setName(textFields[0].getText().trim());
                        doctor.setAddress(textFields[1].getText().trim());
                        doctor.setPhoneNumber(textFields[2].getText().trim());
                        doctor.setSpecialty(textFields[3].getText().trim());

                        JOptionPane.showMessageDialog(this, "Doctor information updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        HealthcareSystem.getInstance().editDoctor(id, textFields[0].getText().trim(), textFields[1].getText().trim(), textFields[2].getText().trim(), textFields[3].getText().trim());
                    } else {
                        JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });

                contentPanel.revalidate();
                contentPanel.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Doctor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add the form panel to the content panel
        contentPanel.add(formPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void displayDoctors() {
        contentPanel.removeAll();

        // Create a panel for the layout
        JPanel tablePanel = new JPanel(new BorderLayout());

        // Header label
        JLabel headerLabel = new JLabel("All Doctors", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(mainBackgroundColor);
        tablePanel.add(headerLabel, BorderLayout.NORTH);

        // Fetch data for the table
        HealthcareSystem system = HealthcareSystem.getInstance();
        List<Doctor> doctors = system.getAllDoctors();

        // Column names for the table
        String[] columnNames = {"ID", "Name", "Address", "Phone", "Specialty",};

        // Prepare data for the table
        Object[][] data = new Object[doctors.size()][7];
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            data[i][0] = doctor.getId();
            data[i][1] = doctor.getName();
            data[i][2] = doctor.getAddress();
            data[i][3] = doctor.getPhoneNumber();
            data[i][4] = doctor.getSpecialty();
        }

        // Create the table with the data and column names
        JTable table = new JTable(data, columnNames);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(30);

        // Customize table appearance
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.BOLD, 14));
        tableHeader.setBackground(mainBackgroundColor);
        tableHeader.setForeground(Color.WHITE);

        table.setShowGrid(true);
        table.setGridColor(Color.LIGHT_GRAY);

        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Add the table panel to the content panel
        contentPanel.add(tablePanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void deleteDoctor() {
        contentPanel.removeAll();

        // Create a panel for the form layout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Header label
        JLabel headerLabel = new JLabel("Delete A Doctor", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(mainBackgroundColor);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(headerLabel, gbc);

        // Reset gridwidth and anchor for the other components
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Search field for Doctor ID
        JLabel searchLabel = new JLabel("Enter Doctor ID:");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Delete");

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(searchLabel, gbc);

        gbc.gridx = 1;
        formPanel.add(searchField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(searchButton, gbc);

        // Action listener for the search button
        searchButton.addActionListener(e -> {
            String id = searchField.getText().trim();
            HealthcareSystem system = HealthcareSystem.getInstance();
            Doctor doctor = system.getDoctorById(id);

            if (doctor != null) {
                system.deleteDoctor(id);
                JOptionPane.showMessageDialog(this, "Doctor Deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Doctor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add the form panel to the content panel
        contentPanel.add(formPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    //TODO == PATIENT == TODO TODO TODO TODO TODO TODO TODO TODO TODO
    private void showPatientOperations() {
        contentPanel.removeAll();

        JLabel header = new JLabel("Patient Operations", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        contentPanel.add(header, BorderLayout.NORTH);

        JPanel patientPanel = new JPanel();
        patientPanel.setLayout(new GridLayout(5, 1, 10, 10));
        patientPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        // Add Patient button
        JButton addPatientBtn = new JButton("Add New Patient");
        styleButton(addPatientBtn);
        addPatientBtn.addActionListener(e -> addPatient());
        patientPanel.add(addPatientBtn);

        // Edit Patient button
        JButton editPatientBtn = new JButton("Edit Patient");
        styleButton(editPatientBtn);
        editPatientBtn.addActionListener(e -> editPatient());
        patientPanel.add(editPatientBtn);

        // Display Patients button
        JButton displayPatientsBtn = new JButton("Display All Patients");
        styleButton(displayPatientsBtn);
        displayPatientsBtn.addActionListener(e -> displayPatients());
        patientPanel.add(displayPatientsBtn);

        //Display Emergency Patients button
        JButton displayEmergencyPatientsBtn = new JButton("Display Emergency Patients");
        styleButton(displayEmergencyPatientsBtn);
        displayEmergencyPatientsBtn.addActionListener(e -> displayEmergencyPatients());
        patientPanel.add(displayEmergencyPatientsBtn);

        // Delete Patient button
        JButton deletePatientBtn = new JButton("Delete Patient");
        styleButton(deletePatientBtn);
        deletePatientBtn.addActionListener(e -> deletePatient());
        patientPanel.add(deletePatientBtn);

        contentPanel.add(patientPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void addPatient() {
        contentPanel.removeAll();

        // Create a panel for the form layout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Header label
        JLabel headerLabel = new JLabel("Add New Patient...", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(mainBackgroundColor);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(headerLabel, gbc);

        // Reset gridwidth and anchor for the other components
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Create and add labels and text fields
        JLabel[] labels = new JLabel[8];
        JTextField[] textFields = new JTextField[8];
        String[] labelTexts = {"ID:", "Name:", "Address:", "Phone:", "Symptoms", "Payment Method", "Diagnosis", "Room Number (Emergency)"};

        for (int i = 0; i < 8; i++) {
            labels[i] = new JLabel(labelTexts[i]);
            textFields[i] = new JTextField(20);

            gbc.gridx = 0;
            gbc.gridy = i + 1;  // Start below the header
            formPanel.add(labels[i], gbc);

            gbc.gridx = 1;
            formPanel.add(textFields[i], gbc);
        }

        // TODO Create and add radio buttons
        JLabel ratioLabel = new JLabel("Gender:");
        gbc.gridx = 0;
        gbc.gridy = 10;
        formPanel.add(ratioLabel, gbc);

        JRadioButton option1 = new JRadioButton("Male");
        JRadioButton option2 = new JRadioButton("Female");
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);

        JPanel radioPanel = new JPanel();
        radioPanel.add(option1);
        radioPanel.add(option2);

        gbc.gridx = 1;
        formPanel.add(radioPanel, gbc);

        // Create and add the submit button
        JButton submitButton = new JButton("Add Patient");
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitButton, gbc);

        // Action listener for the submit button
        submitButton.addActionListener(e -> {
            boolean allFieldsFilled = true;
            String genderSelected = option1.isSelected() ? "Male" : option2.isSelected() ? "Female" : "Prefer to not say";
            for (JTextField textField : textFields) {
                String text = textField.getText().trim();
                if (text.isEmpty() && textField != textFields[7]) {
                    textField.setBackground(Color.RED);
                    allFieldsFilled = false;
                } else {
                    textField.setBackground(Color.WHITE);
                }
            }

            if (allFieldsFilled) {
                //TODO Saving Data
                HealthcareSystem system = HealthcareSystem.getInstance();

                if(textFields[7].getText().trim().isEmpty())
                {
                    Patient patient;
                    patient = new Patient(textFields[0].getText().trim(), textFields[1].getText().trim(), textFields[2].getText().trim(), textFields[3].getText().trim(), genderSelected, textFields[4].getText().trim(), textFields[5].getText().trim(), textFields[6].getText().trim());
                    system.addPatient(patient);
                }else{
                    EmergencyPatient patient;
                    patient = new EmergencyPatient(textFields[0].getText().trim(), textFields[1].getText().trim(), textFields[2].getText().trim(), textFields[3].getText().trim(), genderSelected, textFields[4].getText().trim(), textFields[5].getText().trim(), textFields[6].getText().trim(), textFields[7].getText().trim());
                    system.addPatient(patient);
                }


                JOptionPane.showMessageDialog(this, "Patient added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add the form panel to the content panel
        contentPanel.add(formPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void editPatient() {
        contentPanel.removeAll();

        // Create a panel for the form layout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Header label
        JLabel headerLabel = new JLabel("Edit Patient Information", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(mainBackgroundColor);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(headerLabel, gbc);

        // Reset grid width and anchor for the other components
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Search field for Doctor ID
        JLabel searchLabel = new JLabel("Enter Patient ID:");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(searchLabel, gbc);

        gbc.gridx = 1;
        formPanel.add(searchField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(searchButton, gbc);

        // Action listener for the search button
        searchButton.addActionListener(e -> {
            String id = searchField.getText().trim();
            HealthcareSystem system = HealthcareSystem.getInstance();
            Patient patient = system.getPatientById(id);

            if (patient != null) {
                // Clear the panel for the next form
                formPanel.removeAll();

                // Reuse GridBagConstraints
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.CENTER;

                // Header label
                formPanel.add(headerLabel, gbc);

                // Reset gridwidth and anchor for the other components
                gbc.gridwidth = 1;
                gbc.anchor = GridBagConstraints.WEST;

                // Create and add labels and text fields for editing
                JLabel[] labels = new JLabel[7];
                JTextField[] textFields = new JTextField[7];
                String[] labelTexts = {"Name:", "Address:", "Phone:", "Gender", "Symptoms", "Payment Method", "Diagnosis"};
                String[] patientData = {patient.getName(), patient.getAddress(), patient.getPhoneNumber(), patient.getGender(), patient.getSymptoms(), patient.getPaymentMethod(), patient.getDiagnosis()};

                for (int i = 0; i < 7; i++) {
                    labels[i] = new JLabel(labelTexts[i]);
                    textFields[i] = new JTextField(20);
                    textFields[i].setText(patientData[i]);

                    gbc.gridx = 0;
                    gbc.gridy = i + 1;  // Start below the header
                    formPanel.add(labels[i], gbc);

                    gbc.gridx = 1;
                    formPanel.add(textFields[i], gbc);
                }

                // Create and add the submit button
                JButton submitButton = new JButton("Update Doctor");
                gbc.gridx = 0;
                gbc.gridy = 8;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.CENTER;
                formPanel.add(submitButton, gbc);

                // Action listener for the submit button
                submitButton.addActionListener(e1 -> {
                    boolean allFieldsFilled = true;

                    for (JTextField textField : textFields) {
                        String text = textField.getText().trim();
                        if (text.isEmpty()) {
                            textField.setBackground(Color.RED);
                            allFieldsFilled = false;
                        } else {
                            textField.setBackground(Color.WHITE);
                        }
                    }

                    if (allFieldsFilled) {
                        patient.setName(textFields[0].getText().trim());
                        patient.setAddress(textFields[1].getText().trim());
                        patient.setPhoneNumber(textFields[2].getText().trim());
                        patient.setGender(textFields[3].getText().trim());
                        patient.setSymptoms(textFields[4].getText().trim());
                        patient.setPaymentMethod(textFields[5].getText().trim());
                        patient.setDiagnosis(textFields[6].getText().trim());

                        JOptionPane.showMessageDialog(this, "Patient information updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        HealthcareSystem.getInstance().editPatient(id, textFields[0].getText().trim(), textFields[1].getText().trim(), textFields[2].getText().trim(), textFields[3].getText().trim(), textFields[4].getText().trim(), textFields[5].getText().trim(), textFields[6].getText().trim());
                    } else {
                        JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });

                contentPanel.revalidate();
                contentPanel.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Patient ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add the form panel to the content panel
        contentPanel.add(formPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void displayPatients() {
        contentPanel.removeAll();

        // Create a panel for the layout
        JPanel tablePanel = new JPanel(new BorderLayout());

        // Header label
        JLabel headerLabel = new JLabel("All Patients", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(mainBackgroundColor);
        tablePanel.add(headerLabel, BorderLayout.NORTH);

        // Fetch data for the table
        HealthcareSystem system = HealthcareSystem.getInstance();
        List<Patient> patients = system.getAllPatients();

        // Column names for the table
        String[] columnNames = {
            "ID", "Name", "Address", "Phone", "Symptoms",
            "Payment Method", "Diagnosis"
        };

        // Prepare data for the table
        Object[][] data = new Object[patients.size()][7];
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            data[i][0] = patient.getId();
            data[i][1] = patient.getName();
            data[i][2] = patient.getAddress();
            data[i][3] = patient.getPhoneNumber();
            data[i][4] = patient.getSymptoms(); // Adjust according to your Patient class
            data[i][5] = patient.getPaymentMethod(); // Adjust according to your Patient class
            data[i][6] = patient.getDiagnosis(); // Adjust according to your Patient class
        }

        // Create the table with the data and column names
        JTable table = new JTable(data, columnNames);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(30);

        // Customize table appearance
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.BOLD, 14));
        tableHeader.setBackground(mainBackgroundColor);
        tableHeader.setForeground(Color.WHITE);

        table.setShowGrid(true);
        table.setGridColor(Color.LIGHT_GRAY);

        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Add the table panel to the content panel
        contentPanel.add(tablePanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void displayEmergencyPatients() {
        contentPanel.removeAll();

        // Create a panel for the layout
        JPanel tablePanel = new JPanel(new BorderLayout());

        // Header label
        JLabel headerLabel = new JLabel("Emergency Patients", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(mainBackgroundColor);
        tablePanel.add(headerLabel, BorderLayout.NORTH);

        // Fetch data for the table
        HealthcareSystem system = HealthcareSystem.getInstance();
        List<EmergencyPatient> emergencyPatients = system.getEmergencyPatients(); // Assuming you have this method

        // Column names for the table
        String[] columnNames = {
            "ID", "Name", "Address", "Phone", "Symptoms",
            "Payment Method", "Diagnosis", "Room Number"
        };

        // Prepare data for the table
        Object[][] data = new Object[emergencyPatients.size()][8];
        for (int i = 0; i < emergencyPatients.size(); i++) {
            EmergencyPatient patient = emergencyPatients.get(i);
            data[i][0] = patient.getId();
            data[i][1] = patient.getName();
            data[i][2] = patient.getAddress();
            data[i][3] = patient.getPhoneNumber();
            data[i][4] = patient.getSymptoms(); // Adjust according to your Patient class
            data[i][5] = patient.getPaymentMethod(); // Adjust according to your Patient class
            data[i][6] = patient.getDiagnosis(); // Adjust according to your Patient class
            data[i][7] = patient.getRoomNumber(); // Room number specific to EmergencyPatient class
        }

        // Create the table with the data and column names
        JTable table = new JTable(data, columnNames);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(30);

        // Customize table appearance
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.BOLD, 14));
        tableHeader.setBackground(mainBackgroundColor);
        tableHeader.setForeground(Color.WHITE);

        table.setShowGrid(true);
        table.setGridColor(Color.LIGHT_GRAY);

        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Add the table panel to the content panel
        contentPanel.add(tablePanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void deletePatient() {
        contentPanel.removeAll();

        // Create a panel for the form layout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Header label
        JLabel headerLabel = new JLabel("Delete A Patient", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(mainBackgroundColor);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(headerLabel, gbc);

        // Reset gridwidth and anchor for the other components
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Search field for Doctor ID
        JLabel searchLabel = new JLabel("Enter Patient ID:");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Delete");

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(searchLabel, gbc);

        gbc.gridx = 1;
        formPanel.add(searchField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(searchButton, gbc);

        // Action listener for the search button
        searchButton.addActionListener(e -> {
            String id = searchField.getText().trim();
            HealthcareSystem system = HealthcareSystem.getInstance();
            Patient patient = system.getPatientById(id);

            if (patient != null) {
                system.deletePatient(id);
                JOptionPane.showMessageDialog(this, "Patient Deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Patient ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add the form panel to the content panel
        contentPanel.add(formPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }


    //TODO == Appointment == TODO TODO TODO TODO TODO TODO TODO TODO
    private void showAppointments() {
        contentPanel.removeAll();

        JLabel header = new JLabel("Appointments", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        contentPanel.add(header, BorderLayout.NORTH);

        JPanel appointmentPanel = new JPanel();
        appointmentPanel.setLayout(new GridLayout(2, 1, 10, 10));
        appointmentPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        // Add Appointment button
        JButton addAppointmentBtn = new JButton("Add New Appointment");
        styleButton(addAppointmentBtn);
        addAppointmentBtn.addActionListener(e -> addAppointment());
        appointmentPanel.add(addAppointmentBtn);

        // Display Appointments button
        JButton displayAppointmentsBtn = new JButton("Display All Appointments");
        styleButton(displayAppointmentsBtn);
        displayAppointmentsBtn.addActionListener(e -> displayAppointments());
        appointmentPanel.add(displayAppointmentsBtn);

        contentPanel.add(appointmentPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void addAppointment() {
        contentPanel.removeAll();

        // Create a panel for the form layout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Header label
        JLabel headerLabel = new JLabel("Schedule New Appointment", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(mainBackgroundColor);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(headerLabel, gbc);

        // Reset gridwidth and anchor for the other components
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Create and add labels and text fields
        JLabel[] labels = new JLabel[3];
        JTextField[] textFields = new JTextField[3];
        String[] labelTexts = {"Patient ID:", "Doctor ID:", "Appointment Date (YYYY-MM-DD):"};

        for (int i = 0; i < 3; i++) {
            labels[i] = new JLabel(labelTexts[i]);
            textFields[i] = new JTextField(20);

            gbc.gridx = 0;
            gbc.gridy = i + 1;  // Start below the header
            formPanel.add(labels[i], gbc);

            gbc.gridx = 1;
            formPanel.add(textFields[i], gbc);
        }

        // Create and add the submit button
        JButton submitButton = new JButton("Add Appointment");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitButton, gbc);

        // Action listener for the submit button
        submitButton.addActionListener(e -> {
            boolean allFieldsFilled = true;

            for (JTextField textField : textFields) {
                String text = textField.getText().trim();
                if (text.isEmpty()) {
                    textField.setBackground(Color.RED);
                    allFieldsFilled = false;
                } else {
                    textField.setBackground(Color.WHITE);
                }
            }

            if (allFieldsFilled) {
                HealthcareSystem system = HealthcareSystem.getInstance();

                // Check if the patient exists
                Patient patient = system.getPatientById(textFields[0].getText().trim());
                if (patient == null) {
                    JOptionPane.showMessageDialog(this, "Patient does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if the doctor exists
                Doctor doctor = system.getDoctorById(textFields[1].getText().trim());
                if (doctor == null) {
                    JOptionPane.showMessageDialog(this, "Doctor does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Save the appointment
                system.addAppointment(new Appointment(patient.getId(), doctor.getId(), textFields[2].getText().trim()));

                JOptionPane.showMessageDialog(this, "Appointment added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add the form panel to the content panel
        contentPanel.add(formPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void displayAppointments() {
        contentPanel.removeAll();

        // Create a panel for the layout
        JPanel tablePanel = new JPanel(new BorderLayout());

        // Header label
        JLabel headerLabel = new JLabel("Appointments", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(mainBackgroundColor);
        tablePanel.add(headerLabel, BorderLayout.NORTH);

        // Fetch data for the table
        HealthcareSystem system = HealthcareSystem.getInstance();
        List<Appointment> appointments = system.getAppointments();

        // Column names for the table
        String[] columnNames = {"Patient ID", "Doctor ID", "Date"};

        // Prepare data for the table
        Object[][] data = new Object[appointments.size()][3];
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            data[i][0] = appointment.getPatientId();
            data[i][1] = appointment.getDoctorId();
            data[i][2] = appointment.getDate();
        }

        // Create the table with the data and column names
        JTable table = new JTable(data, columnNames);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(30);

        // Customize table appearance
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.BOLD, 14));
        tableHeader.setBackground(mainBackgroundColor);
        tableHeader.setForeground(Color.WHITE);

        table.setShowGrid(true);
        table.setGridColor(Color.LIGHT_GRAY);

        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Add the table panel to the content panel
        contentPanel.add(tablePanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void styleButton(JButton button) {
        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.GRAY); // Change to gray on hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 122, 255)); // Original color
            }
        });
    }
}
