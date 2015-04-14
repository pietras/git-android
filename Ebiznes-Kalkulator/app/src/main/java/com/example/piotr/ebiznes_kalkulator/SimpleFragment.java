package com.example.piotr.ebiznes_kalkulator;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleFragment extends Fragment implements View.OnClickListener{

    Button num0,num1,num2,num3,num4,num5,num6,num7,num8,num9,
            bksp,clear,znak,div,mul,min,plus,equals,przecinek;
    TextView wysw;

    String op;
    static float op1;
    static float op2;
    float res;

    public SimpleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple,container,false);
        num0 = (Button)view.findViewById(R.id.num0);
        num1 = (Button)view.findViewById(R.id.num1);
        num2 = (Button)view.findViewById(R.id.num2);
        num3 = (Button)view.findViewById(R.id.num3);
        num4 = (Button)view.findViewById(R.id.num4);
        num5 = (Button)view.findViewById(R.id.num5);
        num6 = (Button)view.findViewById(R.id.num6);
        num7 = (Button)view.findViewById(R.id.num7);
        num8 = (Button)view.findViewById(R.id.num8);
        num9 = (Button)view.findViewById(R.id.num9);
        bksp = (Button)view.findViewById(R.id.bksp);
        clear = (Button)view.findViewById(R.id.clear);
        znak = (Button)view.findViewById(R.id.znak);
        div = (Button)view.findViewById(R.id.div);
        mul = (Button)view.findViewById(R.id.mul);
        min = (Button)view.findViewById(R.id.min);
        plus = (Button)view.findViewById(R.id.plus);
        equals = (Button)view.findViewById(R.id.equals);
        przecinek = (Button)view.findViewById(R.id.przecinek);
        wysw = (TextView)view.findViewById(R.id.wyswietlacz);

        try{
            num0.setOnClickListener(this);
            num1.setOnClickListener(this);
            num2.setOnClickListener(this);
            num3.setOnClickListener(this);
            num4.setOnClickListener(this);
            num5.setOnClickListener(this);
            num6.setOnClickListener(this);
            num7.setOnClickListener(this);
            num8.setOnClickListener(this);
            num9.setOnClickListener(this);
            bksp.setOnClickListener(this);
            clear.setOnClickListener(this);
            znak.setOnClickListener(this);
            div.setOnClickListener(this);
            mul.setOnClickListener(this);
            min.setOnClickListener(this);
            plus.setOnClickListener(this);
            equals.setOnClickListener(this);
            przecinek.setOnClickListener(this);
        }
        catch (Exception e)
        {System.out.println("Exception przy listenerach");}

        return view;
    }

    public void InsertText(String text){
        wysw.setText(wysw.getText().toString()+text);
    }

    public void Backspace(){
        if (wysw.getText().length() > 0) {
            String s = wysw.getText().toString().substring(0, (wysw.getText().toString().length() - 1));
            wysw.setText(s);
        } else {
            wysw.setText("");
        }
    }

    public void WstawPrzecinek(){
        if(wysw.getText().toString().contains("."))
        {

        }else{
            if(wysw.getText().toString().length()==0)
            {
                wysw.setText("0.");
            }
            else {
                InsertText(".");
            }
        }
    }

    public void ClearText(){
        wysw.setText("");
        op1=0;
        op2=0;
    }

    public void Dodawanko(){
        res=0;
        op1 = Float.parseFloat(wysw.getText().toString());
        if(!wysw.getText().equals("")) {
            op = "+";
            wysw.setText("");
        }
    }
    public void Odejmowanko(){
        op1 = Float.parseFloat(wysw.getText().toString());
        if(!wysw.getText().equals("")) {
            op = "-";
            wysw.setText("");
        }
    }
    public void Mnozenie(){
        op1 = Float.parseFloat(wysw.getText().toString());
        if(!wysw.getText().equals("")) {
            op = "*";
            wysw.setText("");
        }
    }
    public void Dzielenie(){
        op1 = Float.parseFloat(wysw.getText().toString());
        if(!wysw.getText().equals("")) {
            op = "/";
            wysw.setText("");
        }
    }

    public void ZmienZnak()
    {
        String temp = wysw.getText().toString();
        if(temp.length()>0) {
            Float liczba = Float.parseFloat(temp);
            liczba = liczba * (-1);
            String temp2 = liczba.toString();
            wysw.setText(temp2);
        }
        else{
            Toast error = Toast.makeText(getActivity(), "Nie zmieniono znaku (nie bylo liczby)", Toast.LENGTH_SHORT);
            error.show();
        }
    }


    public void Wynik(){
        if(!wysw.getText().toString().equals(""))
        {
            op2=Float.parseFloat(wysw.getText().toString());
            if(op!=null) {
                {
                    if (op.equals("+")) {
                        wysw.setText("");
                        res = op1 + op2;
                        InsertText(Float.toString(res));
                        res = 0;
                        op = null;
                    } else if (op.equals("-")) {
                        wysw.setText("");
                        res = op1 - op2;
                        InsertText(Float.toString(res));
                        res = 0;
                        op = null;
                    } else if (op.equals("/")) {
                        if (wysw.getText().toString().equals("0")) {
                            Toast error = Toast.makeText(getActivity(), "Nie dzielimy przez 0", Toast.LENGTH_SHORT);
                            error.show();
                        } else {
                            wysw.setText("");
                            res = op1 / op2;
                            InsertText(Float.toString(res));
                            res = 0;
                            op = null;
                        }
                    } else if (op.equals("*")) {
                        wysw.setText("");
                        res = op1 * op2;
                        InsertText(Float.toString(res));
                        res = 0;
                        op = null;
                    }
                }
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.num0 : InsertText("0"); break;
            case R.id.num1 : InsertText("1"); break;
            case R.id.num2 : InsertText("2"); break;
            case R.id.num3 : InsertText("3"); break;
            case R.id.num4 : InsertText("4"); break;
            case R.id.num5 : InsertText("5"); break;
            case R.id.num6 : InsertText("6"); break;
            case R.id.num7 : InsertText("7"); break;
            case R.id.num8 : InsertText("8"); break;
            case R.id.num9 : InsertText("9"); break;
            case R.id.przecinek : WstawPrzecinek(); break;
            case R.id.clear : ClearText(); break;
            case R.id.bksp : Backspace(); break;
            case R.id.plus : Dodawanko(); break;
            case R.id.min : Odejmowanko(); break;
            case R.id.mul : Mnozenie(); break;
            case R.id.div : Dzielenie(); break;
            case R.id.znak : ZmienZnak(); break;
            case R.id.equals : Wynik(); break;
        }

    }
}
