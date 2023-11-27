package decoder.Message.Parametric;

import decoder.Sentence.Sentence;

import java.util.LinkedList;

public class Pmessage {
    public Pmessage(){
    }
    public void init(LinkedList<Sentence> _sentence){
        if (_sentence.peek().getFormatter().equals("AAM")){
            AAM m = new AAM();
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("ABK")){
            ABK m = new ABK(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }
        else if(_sentence.peek().getFormatter().equals("ACA")){
            ACA m = new ACA(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }
        else if(_sentence.peek().getFormatter().equals("ACK")){
            ACK m = new ACK(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }
        else if(_sentence.peek().getFormatter().equals("ACS")){
            ACS m = new ACS(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }
        else if(_sentence.peek().getFormatter().equals("AIR")){
            AIR m = new AIR(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }
        else if(_sentence.peek().getFormatter().equals("ALM")){
            ALM m = new ALM(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }
        else if(_sentence.peek().getFormatter().equals("ALR")){
            ALR m = new ALR(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }
        else if(_sentence.peek().getFormatter().equals("APB")){
            APB m = new APB(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }
        else if(_sentence.peek().getFormatter().equals("BEC")){
            BEC m = new BEC(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }
        else if(_sentence.peek().getFormatter().equals("BOD")){
            BOD m = new BOD(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }
        else if(_sentence.peek().getFormatter().equals("BWC") || _sentence.peek().getFormatter().equals("BWR")){
            BWC m = new BWC(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("CUR")){
            CUR m = new CUR(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("DBT")){
            DBT m = new DBT(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("DCN")){
            DCN m = new DCN(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("DPT")){
            DPT m = new DPT(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("DSC")){
            DSC m = new DSC(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("DTM")){
            DTM m = new DTM(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("GBS")){
            GBS m = new GBS(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("GGA")){
            GGA m = new GGA(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("GLC")){
            GLC m = new GLC(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("GLL")){
            GLL m = new GLL(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("GMP")){
            GMP m = new GMP(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("GNS")){
            GNS m = new GNS(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("GRS")){
            GRS m = new GRS(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("GSA")){
            GSA m = new GSA(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("GST")){
            GST m = new GST(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }
        else if(_sentence.peek().getFormatter().equals("GSV")){
            GSV m = new GSV(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("HDG")){
            HDG m = new HDG(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("HDT")){
            HDT m = new HDT(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("HMR")){
            HMR m = new HMR(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("HMS")){
            HMS m = new HMS(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }else if(_sentence.peek().getFormatter().equals("HSC")){
            HSC m = new HSC(){};
            m.decode(_sentence.peek().getSentenceString());
            m.setTalker(_sentence.peek().getTalker());
            m.setFormat(_sentence.peek().getFormatter());
            m.json();
            m.table();
        }
    };

}
