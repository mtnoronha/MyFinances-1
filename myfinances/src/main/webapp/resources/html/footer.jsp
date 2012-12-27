<%@ taglib uri="http://myfinances.sourcesphere.com.br/taglib" prefix="sourcesphere"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/resources/jquery/JQuery.js" var="jquery"/>

<script type="text/javascript" src="${jquery}">

$(document).ready(function() 
{
    //Configuração do plugin
    $('#divHorario').epiclock({
        mode: EC_LOOP,
        onTimer: tick
    });
 
    //Inicia a contagem
    $.epiclock();
});
 
function tick() 
{
    $('#divHorario').html("<sourcesphere:HoraAtual/>");
}

</script>

<br/><br/>
<div class="navbar navbar-fixed-bottom">
    <div class="navbar-inner">
	   	<div id="divHorario" class="container pull-right">
		    	<sourcesphere:HoraAtual/>
	    </div>
    </div>
</div>
</body>
</html>