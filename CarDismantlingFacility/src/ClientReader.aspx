<%@ Page Language="C#" %>
<%@ Import localhost\WebContent\wdsl\ChassisRetriever.wdsl %>
<script runat ="server">
    void getChassis(int reg)
    {
       
         ChassisRtriever = new ChassisRetriever(reg);
        
    }
</script>

<html>

    <body>
        <form runat ="server"">
            <p>
                <em>Part registration number</em>
                <asp:TextBox ID = "txtNum1" runat ="server"  Width =" 43px">0</asp:TextBox>
            </p>
                
            <p>
                <strong><u>Web Service Result</u></strong>
            </p>

            <p>
                <em>Verification</em> :
                <asp:Label ID ="Label1" runat =  "server" Font-Underline="true">Label</asp:Label>
            </p>

            <p>
                <asp:Button ID="runService" OnClick ="runService_Click" runat ="server" Text ="Find chassis" />
            </p>
        </form>
    </body>
</html>
