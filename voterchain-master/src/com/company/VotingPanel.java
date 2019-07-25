/*
 * Created by JFormDesigner on Wed Apr 03 14:22:45 IST 2019
 */

package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;


import static com.company.Vote.voterIds;

/**
 * @author Ajith
 */
public class VotingPanel extends JFrame {
    int status =0;
    public static int difficulty = 4;
    private static String previousHash ="0";
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static ArrayList<Vote> votes = new ArrayList<Vote>();
    static int[] result = new int[9];

    public VotingPanel() {
        for (int i=0;i<9;i++)
        {
            result[i] =0;
        }
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        String voterId = textField1.getText();

        if(voterId.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Enter VoterId");
        }
        else
        {
            if(checkBox1.isSelected()||checkBox2.isSelected()||checkBox3.isSelected()||checkBox4.isSelected()||checkBox5.isSelected()||checkBox6.isSelected()||checkBox7.isSelected()||checkBox8.isSelected())
            {
                if(checkBox1.isSelected())
                {
                    status = 1;
                }
                else if(checkBox2.isSelected())
            {
                status = 4;
            }
            else if(checkBox3.isSelected())
            {
                status = 2;
            }
            else if(checkBox4.isSelected())
            {
                status = 7;
            } else if(checkBox5.isSelected())
            {
                status = 5;
            } else if(checkBox6.isSelected())
            {
                status = 3;
            } else if(checkBox7.isSelected())
            {
                status = 8;
            }
            else if(checkBox8.isSelected())
            {
                status = 6;
            }
            }
            if(status==0)
            {
                JOptionPane.showMessageDialog(null,"Please Cast your Vote");
            }
            else
            {
                Vote vote = new Vote(voterId,String.valueOf(status));
                if(vote.verifyVote())
                {
                    JOptionPane.showMessageDialog(null,"Your Vote has been registered!!");
                    voterIds.add(vote.getVoterId());
                    votes.add(vote);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You cannot Vote!!");
                }
            }

        }
    }


    private void button2ActionPerformed(ActionEvent e) {
        if(!votes.isEmpty())
        {
            previousHash = addVoteToBlock(votes,previousHash);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"There is nothing to mine");
        }
    }


    private void button3ActionPerformed(ActionEvent e) {

    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void viewResults(ActionEvent e) {
        int flag=0;
        for (int i=0;i<voterIds.size();i++)
        {
            if(textField1.getText().toString().equals(voterIds.get(i)))
            {
                flag = 1;
            }
        }
        if(flag ==1) {
            Results results = new Results(result);
            results.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please vote to see results!!");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ajith Kanduri
        textField1 = new JTextField();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();
        checkBox5 = new JCheckBox();
        checkBox6 = new JCheckBox();
        checkBox4 = new JCheckBox();
        checkBox7 = new JCheckBox();
        checkBox8 = new JCheckBox();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- checkBox1 ----
        checkBox1.setText("YSRCP");

        //---- checkBox2 ----
        checkBox2.setText("JANA SENA");

        //---- checkBox3 ----
        checkBox3.setText("BJP");

        //---- checkBox5 ----
        checkBox5.setText("TDP");

        //---- checkBox6 ----
        checkBox6.setText("TRS");

        //---- checkBox4 ----
        checkBox4.setText("CONGRESS");

        //---- checkBox7 ----
        checkBox7.setText("NOTA");

        //---- checkBox8 ----
        checkBox8.setText("AAP");

        //---- button1 ----
        button1.setText("VOTE");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText("MINE BLOCK");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });

        //---- button3 ----
        button3.setText("VIEW RESULTS");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3ActionPerformed(e);
                viewResults(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(158, 158, 158)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                            .addComponent(button2)
                            .addGap(9, 9, 9))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(checkBox8, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addComponent(checkBox5, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addComponent(checkBox6, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addComponent(checkBox1, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createParallelGroup()
                                            .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(checkBox3, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                            .addGap(114, 114, 114)
                                            .addComponent(checkBox2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                        .addGap(114, 114, 114)
                                        .addComponent(checkBox4, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addGap(114, 114, 114)
                                    .addComponent(checkBox7, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))))
                    .addGap(200, 200, 200))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(249, 249, 249)
                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(282, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addGap(43, 43, 43)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(checkBox3)
                        .addComponent(checkBox1))
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(checkBox2)
                        .addComponent(checkBox6))
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(checkBox4)
                        .addComponent(checkBox5))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(checkBox7)
                        .addComponent(checkBox8))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addGap(30, 30, 30)
                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(checkBox1);
        buttonGroup1.add(checkBox2);
        buttonGroup1.add(checkBox3);
        buttonGroup1.add(checkBox5);
        buttonGroup1.add(checkBox6);
        buttonGroup1.add(checkBox4);
        buttonGroup1.add(checkBox7);
        buttonGroup1.add(checkBox8);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public static String addVoteToBlock(ArrayList<Vote> vote,String previousHash)
    {
        System.out.println("Trying To mineBlock...");

            Block block = new Block(vote, previousHash);
            block.mineBlock(difficulty);
            if (verifyChain(block)) {
                blockchain.add(block);
                for (int i=0;i<votes.size();i++)
                {
                    result[Integer.parseInt(votes.get(i).getVoteParty())]++;
                }
                votes.clear();
            }
            return block.getBlockHash();

    }


    public static boolean verifyChain(Block block){
        for(int i=1;i<blockchain.size();i++){
            if(!(blockchain.get(i).getPreviousHash()==blockchain.get(i-1).getBlockHash()))
            {
                return false;
            }
        }
        if(blockchain.size()>0) {
            if (!(blockchain.get(blockchain.size()-1).getBlockHash() == block.getPreviousHash())) {
                return false;
            }
        }
        return true;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ajith Kanduri
    private JTextField textField1;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private JCheckBox checkBox4;
    private JCheckBox checkBox7;
    private JCheckBox checkBox8;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

