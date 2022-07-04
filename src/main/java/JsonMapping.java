import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.json.mapping.module.*;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class JsonMapping {
    public static void main(String[] args) throws IOException {

        SiblingChild siblingChild =new SiblingChild();
        siblingChild.setLeafId(1);
        siblingChild.setSmsPeriodId("20221408");
        siblingChild.setYear("2022");
        siblingChild.setPeriodStartDate("01-Jan-2022");
        siblingChild.setPeriodEndDate("01-Mar-2022");
        siblingChild.setPeriodTag("bonus");
        siblingChild.setPeriodLabel("MM2022008");
        siblingChild.setNoOfDays("30");
        siblingChild.setPeriodSeq("0");
        siblingChild.setSwitchPeriodSet("1");


        SiblingChild siblingChildTemp =new SiblingChild();
        siblingChildTemp.setLeafId(2);
        siblingChildTemp.setSmsPeriodId("20221502");
        siblingChildTemp.setYear("2022");
        siblingChildTemp.setPeriodStartDate("01-Jan-2022");
        siblingChildTemp.setPeriodEndDate("01-Apr-2022");
        siblingChildTemp.setPeriodTag("bonus");
        siblingChildTemp.setPeriodLabel("MM2022015");
        siblingChildTemp.setNoOfDays("30");
        siblingChildTemp.setPeriodSeq("1");
        siblingChildTemp.setSwitchPeriodSet("2");

        ParentSiblingChild<SiblingChild> parentSiblingChild =new ParentSiblingChild<>();
        parentSiblingChild.setPeriodGroup("Monthly_Cycle_Group 1");
        parentSiblingChild.setText("Monthly_Cycle_Group 1");
        parentSiblingChild.setPeriodGroupId("1");

        ParentSiblingChild<SiblingChild> parentSiblingChildTemp =new ParentSiblingChild<>();
        parentSiblingChildTemp.setSiblingChild(siblingChildTemp);

        ParentSiblingChild<SiblingChild> childParentSiblingChild =new ParentSiblingChild<>();
        childParentSiblingChild.setSiblingChild(siblingChild);

        parentSiblingChild.setParentSiblingChildren(Arrays.asList(parentSiblingChildTemp,
                childParentSiblingChild));

        ParentRoot parentRoot=new ParentRoot();
        parentRoot.setSiblingChild(Collections.singletonList(parentSiblingChild));

        BaseRootSiblings baseRootSiblings=new BaseRootSiblings();
        baseRootSiblings.setStatusCode("success");
        baseRootSiblings.setStatusCode("100");
        baseRootSiblings.setStatusCode("success_msg");

        BaseRoot baseRoot=new BaseRoot();
        baseRoot.setParentRoot(parentRoot);
        baseRoot.setBaseRootSiblings(baseRootSiblings);

        System.out.println(new StringBuilder("\n*********************************").append("Total Document Count:-").append(baseRoot.getTotalCount())
                .append("******************************"));
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        String jsonString= objectMapper.writeValueAsString(baseRoot);
        fileOperations(jsonString);
    }

    private static void fileOperations(String jsonString) throws IOException {
        String filePath=new StringBuilder("src")
                .append(File.separator)
                .append("main")
                .append(File.separator)
                .append("resources")
                .append(File.separator)
                .append("sample.json").toString();
        File file=new File(filePath);
        if(file.exists()) file.delete();
        file.createNewFile();
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        fileOutputStream.write(jsonString.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
