package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Block {
    private ArrayList<Vote> voteObj;
    private String previousHash;
    private String blockHash;
    public long timeStamp;
    public int nonce;
    private int sum=0;
    public Block(ArrayList<Vote> vote, String previousHash)
    {
        this.previousHash=previousHash;
        this.timeStamp = new Date().getTime();
        voteObj=vote;
        this.blockHash=calculateHash();
    }
    //Calculate new hash based on blocks contents
    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                       calcSum() +
                        Integer.toString(nonce)

        );
        return calculatedhash;
    }
    private int calcSum()
    {
        for (int i=0;i<voteObj.size();i++)
        {
            sum = sum+Integer.parseInt(voteObj.get(i).getVoterId());
        }
        return sum;
    }
    //Increases nonce value until hash target is reached.
    public void mineBlock(int difficulty) {

        String target = StringUtil.getDificultyString(difficulty); //Create a string with difficulty * "0"
        while(!blockHash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            blockHash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + blockHash);
    }
    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }
}
