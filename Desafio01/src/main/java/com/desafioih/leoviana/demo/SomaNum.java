package com.desafioih.leoviana.demo;

import javax.swing.*;

public class SomaNum {
    public static void main(final String args[])
    {
    
    int soma;
    int num1=0;
    int num2=0;

    num1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite um numero:"));
    num2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite outro numero:"));
    
    soma= num1+num2;
    JOptionPane.showMessageDialog(null,"A soma dos numeros e:"+soma);
    
    }
    }

