<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>File Upload</title>
    <script
            src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            //add more file components if Add is clicked
            $('#addFile').click(function() {
                var fileIndex = $('#fileTable tr').children().length - 1;
                $('#fileTable').append(
                        '<tr><td>'+
                                '   <input type="file" name="files['+ fileIndex +']" />'+
                                '</td></tr>');
            });

        });
    </script>
</head>
<body>
<h1>Upload File</h1>

<form:form method="post" action="upload"
           modelAttribute="uploadForm" enctype="multipart/form-data">

    <p>Select files to upload</p>

    <table id="fileTable">
        <tr>
            <td><input name="files[0]" type="file" /></td>
        </tr>
    </table>
    <br/><input type="submit" value="Upload" />
</form:form>
</body>
</html>