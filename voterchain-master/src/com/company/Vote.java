package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Vote implements Serializable
{
    private String voterId;
    static ArrayList<String> voterIds = new ArrayList<String>();
    private String voteParty;
    public static  ArrayList<String> ids = new ArrayList<String>();

    public Vote(String voterId, String voteParty)
    {
        ids.add("1");
        ids.add("2");
        ids.add("3");
        ids.add("4");
        ids.add("5");
        ids.add("6");
        ids.add("7");
        ids.add("8");
        ids.add("9");
        ids.add("10");
        this.voterId=voterId;
        this.voteParty=voteParty;
    }
    public boolean verifyVote()
    {
        for (int i=0;i<voterIds.size() ;i++ ) {
            //if encrypted try to decrpyt here.
            if(voterIds.get(i).equals(voterId))
            {
                return false;
            }
        }
        for (int i=0;i<ids.size();i++)
        {
            if(ids.get(i).equals(voterId))
            {
                addVoter();
                return true;
            }
        }

        return false;
    }
    public void addVoter()
    {
        //can even encrypt the voterIds before adding to arrayList.
        voterIds.add(voterId);
    }
    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }
    public String getVoteParty() {
        return voteParty;
    }

    public void setVoteParty(String voteParty) {
        this.voteParty = voteParty;
    }
}
