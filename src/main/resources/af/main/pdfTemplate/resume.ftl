<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Title</title>
    <style>
        body {
            font-family: SimHei;
        }

        .pos {
            position: absolute;
            left: 100px;
            top: 150px
        }
    </style>
</head>
<body>
<div class="blue pos">
<h2 style="text-align:center">職　務　経　歴　書</h2>
<span>■基本情報</span>
<table border=1 cellspacing=0 cellpadding=0 width="98%"
 style='width:98.5%;margin-left:-142.35pt;border-collapse:collapse;border:none;'>
 <tr>
  <td rowspan=3 align=center style='width:3%;border:solid black .5pt;
  background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'><o:p>氏<br/>名</o:p></span></p>
  </td>
  <td align=center style='width:5%;border:solid black .5pt;
  background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>カナ<span><o:p></o:p></span></span></p>
  </td>
  <td align=center style='width:25%;border:solid black .5pt;
  background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>トウ　ギョウホ<span><o:p></o:p></span></span></p>
  </td>
  <td align=center style='width:7%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>性別<span><o:p></o:p></span></span></p>
  </td>
  <td align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>生年月日/年齢<span><o:p></o:p></span></span></p>
  </td>
  <td align=center style='width:12%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>日本語能力<span><o:p></o:p></span></span></p>
  </td>
  <td align=center style='width:10%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>国籍<span><o:p></o:p></span></span></p>
  </td>
  <td align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>最寄駅<span><o:p></o:p></span></span></p>
  </td>
 </tr>
 <tr>
  <td rowspan=2 align=center style='width:5%;border:solid black .5pt;
  background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>氏名<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=2　align=center style='width:25%;border:solid black .5pt;
  background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>${resumeBase.nameKj}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=2　valign=center style='width:7%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>${resumeBase.gender}<span><o:p></o:p></span></span></p>
  </td>
  <td align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>${resumeBase.birthday}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=2　align=center style='width:12%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>${resumeBase.jpLevel}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=2　align=center style='width:10%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>${resumeBase.country}<span><o:p></o:p></span></span></p>
  </td>
  <td align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>JR線<span><o:p></o:p></span></span></p>
  </td>
 </tr>
 <tr>
  <td align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>${resumeBase.age} 歳<span><o:p></o:p></span></span></p>
  </td>
  <td align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>${resumeBase.station}<span><o:p></o:p></span></span></p>
  </td>
 </tr>
 <tr>
  <td colspan=3 align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>最終学歴<span><o:p></o:p></span></span></p>
  </td>
  <td colspan=2 align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>専  攻<span><o:p></o:p></span></span></p>
  </td>
  <td colspan=1 align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>卒業年月<span><o:p></o:p></span></span></p>
  </td>
  <td colspan=1 align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>実務経験<span><o:p></o:p></span></span></p>
  </td>
  <td colspan=1 align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>来日年度<span><o:p></o:p></span></span></p>
  </td>
 </tr>

 <tr>
  <td colspan=3 align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>${resumeBase.education}<span><o:p></o:p></span></span></p>
  </td>
  <td colspan=2 align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>${resumeBase.major}<span><o:p></o:p></span></span></p>
  </td>
  <td colspan=1 align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>${resumeBase.graduation}<span><o:p></o:p></span></span></p>
  </td>
  <td colspan=1 align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>${resumeBase.workYears}年<span><o:p></o:p></span></span></p>
  </td>
  <td colspan=1 align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>${resumeBase.japanYears}年<span><o:p></o:p></span></span></p>
  </td>
 </tr>
</table>
<br/>
<span>■スキルレベル</span>
<div align="center">
<table border=1 cellspacing=0 cellpadding=0 width="98%"
 style='width:98.5%;margin-left:-142.35pt;border-collapse:collapse;border:none;'>
 <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
  <td valign=top style='width:7.82%;border:solid black .5pt;
  background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'><o:p>&nbsp;</o:p></span></p>
  </td>
  <td valign=top style='width:14.06%;border:solid black .5pt;
  background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>言語環境<span><o:p></o:p></span></span></p>
  </td>
  <td valign=top style='width:14.06%;border:solid black .5pt;
  background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>期間<span><o:p></o:p></span></span></p>
  </td>
  <td valign=top style='width:64.06%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:10.0pt;'>レベル<span><o:p></o:p></span></span></p>
  </td>
 </tr>
 <#list programLanguage as skill>
 <tr>
 <#if skill_index = 0>
  <td rowspan=${programLanguage?size} valign=top align=center style='width:7.82%;border-top:none;
  border-left:solid black .5pt;border-bottom:solid black .5pt;background:white;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:9.0pt;'>言語<span><o:p></o:p></span></span></p>
  </td>
 </#if>
  <td valign=top style='width:14.06%;border-top:none;border-left:none;
  border-bottom:solid black .5pt;border-right:solid black .5pt;
  background:white;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:3.0pt'><span style='font-size:9.0pt;'>${skill.skill}<o:p></o:p></span></p>
  </td>
  <td valign=top style='width:14.06%;border-top:none;border-left:
  none;border-bottom:solid black .5pt;border-right:solid black .5pt;
  background:white;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:3.0pt'><span style='font-size:9.0pt;'>${skill.period}<span><o:p></o:p></span></span></p>
  </td>
  <td valign=top style='width:64.06%;border-top:none;border-left:none;
  border-bottom:solid black .5pt;border-right:solid black .5pt;
  background:white;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:3.0pt'><span style='font-size:9.0pt;'>${skill.level}<span><o:p></o:p></span></span></p>
  </td>
 </tr>
 </#list>
 <#list skill_db as skill>
 <tr>
 <#if skill_index = 0>
  <td rowspan=${skill_db?size} valign=top align=center style='width:7.82%;border-top:none;
  border-left:solid black .5pt;border-bottom:solid black .5pt;background:white;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.8pt'><span style='font-size:9.0pt;'>DB<span><o:p></o:p></span></span></p>
  </td>
 </#if>
  <td valign=top style='width:14.06%;border-top:none;border-left:none;
  border-bottom:solid black .5pt;border-right:solid black .5pt;
  background:white;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:3.0pt'><span style='font-size:9.0pt;'>${skill.skill}<o:p></o:p></span></p>
  </td>
  <td valign=top style='width:14.06%;border-top:none;border-left:none;
  border-bottom:solid black .5pt;border-right:solid black .5pt;
  background:white;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:3.0pt'><span style='font-size:9.0pt;'>${skill.period}<span><o:p></o:p></span></span></p>
  </td>
  <td valign=top style='width:64.06%;border-top:none;border-left:none;
  background:white;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:3.0pt'><span style='font-size:9.0pt;'>${skill.level}<span><o:p></o:p></span></span></p>
  </td>
 </tr>
 </#list>
  <#list skill_os as skill>
 <tr>
 <#if skill_index = 0>
  <td rowspan=${skill_os?size} valign=top align=center style='width:7.82%;border-top:none;
  border-left:solid black .5pt;border-bottom:solid black .5pt;background:white;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:9.0pt;'>OS<span><o:p></o:p></span></span></p>
  </td>
 </#if>
  <td valign=top style='width:14.06%;border-top:none;border-left:none;
  border-bottom:solid black .5pt;border-right:solid black .5pt;
  background:white;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:3.0pt'><span style='font-size:9.0pt;'>${skill.skill}<o:p></o:p></span></p>
  </td>
  <td valign=top style='width:14.06%;border-top:none;border-left:none;
  border-bottom:solid black .5pt;border-right:solid black .5pt;
  background:white;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:3.0pt'><span style='font-size:9.0pt;'>${skill.period}<span><o:p></o:p></span></span></p>
  </td>
  <td valign=top style='width:64.06%;border-top:none;border-left:
  none;border-bottom:solid black .5pt;border-right:solid black .5pt;
  background:white;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:3.0pt'><span style='font-size:9.0pt;'>${skill.level}<span><o:p></o:p></span></span></p>
  </td>
 </tr>
 </#list>
</table>
</div>
<br/>
<span>■職務経歴</span>
<div align="center">
<table border=1 cellspacing=0 cellpadding=0 width="98%"
 style='width:98.5%;margin-left:-142.35pt;border-collapse:collapse;border:none;'>
 <tr>
  <td rowspan=4 align=center style='width:2%;border:solid black .5pt;
  background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:10.0pt;'><o:p>No</o:p></span></p>
  </td>
  <td rowspan=4 align=center style='width:6%;border:solid black .5pt;
  background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:10.0pt;'><o:p>開発期間</o:p></span></p>
  </td>
  <td rowspan=4 align=center style='width:5%;border:solid black .5pt;
  background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:10.0pt;'><o:p>勤務地</o:p></span></p>
  </td>
  <td rowspan=4 colspan=4 align=center style='width:20%;border:solid black .5pt;
  background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:10.0pt;'>プロジェクト名及び作業内容<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=center style='width:7%;border:solid black .5pt;
  background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:10.0pt;'>OS/DB<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=center style='width:8%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:10.0pt;'>言語/ツール<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=center style='width:3%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:10.0pt;'>役<br/>割<span><o:p></o:p></span></span></p>
  </td>
  <td colspan=9 align=center style='width:15%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:10.0pt;'>開発フェーズ<span><o:p></o:p></span></span></p>
  </td>
 </tr>
 <tr>
  <td rowspan=3 valign=top align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:6.0pt;'>要<br/>件<br/>定<br/>義<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=3 valign=top align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:6.0pt;'>基<br/>本<br/>設<br/>計<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=3 valign=top align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:6.0pt;'>機<br/>能<br/>設<br/>計<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=3 valign=top align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:6.0pt;'>詳<br/>細<br/>設<br/>計<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=3 valign=top align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:6.0pt;'>製<br/>造<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=3 valign=top align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:6.0pt;'>単<br/>体<br/>試<br/>験<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=3 valign=top align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:6.0pt;'>結<br/>合<br/>試<br/>験<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=3 valign=top align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:6.0pt;'>総<br/>合<br/>試<br/>験<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=3 valign=top align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#CCCCCC;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:6.0pt;'>運<br/>用<br/>保<br/>守<span><o:p></o:p></span></span></p>
  </td>
 </tr>

 <#list projects as project>
 <tr>
  <td rowspan=4 valign=top align=center style='width:2%;border-top:none;
  border-left:solid black .5pt;border-bottom:solid black .5pt;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:9.0pt;'>${project.no}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=center style='width:6%;border:solid black .5pt;
  background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:10.0pt;'><o:p>${project.devFrom}<br/>～<br/>${project.devTo}</o:p></span></p>
  </td>
  <td rowspan=4 align=center style='width:5%;border:solid black .5pt;
  background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:10.0pt;'><o:p>${project.workplace}</o:p></span></p>
  </td>
  <td rowspan=1 align=left style='width:2%;border:solid black .5pt;
  background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:2.0pt'><span style='font-size:6.5pt;'>案件名<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=1 align=left style='width:12%;border:solid black .5pt;
  background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:2.0pt'><span style='font-size:6.0pt;'>${project.projectName}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=1 align=left style='width:2%;border:solid black .5pt;
  background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:2.0pt'><span style='font-size:6.5pt;'>業種<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=1 align=left style='width:3%;border:solid black .5pt;
  background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:2.0pt'><span style='font-size:6.0pt;'>${project.projectType}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=left style='width:7%;border:solid black .5pt;
  background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.0pt'><span style='font-size:10.0pt;'>${project.OS}/${project.DB}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=left style='width:8%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:4.0pt'><span style='font-size:10.0pt;'>${project.devLanguage}/${project.devTool}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=center style='width:3%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:10.0pt;'>${project.charge}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:8.0pt;'>${project.devPhase.require}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p ><span style='font-size:8.0pt;'>${project.devPhase.baseDesign}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:8.0pt;'>${project.devPhase.functionDesign}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:8.0pt;'>${project.devPhase.detailDesign}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:8.0pt;'>${project.devPhase.coding}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:8.0pt;'>${project.devPhase.unitTest}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:8.0pt;'>${project.devPhase.interfaceTest}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:8.0pt;'>${project.devPhase.systemTest}<span><o:p></o:p></span></span></p>
  </td>
  <td rowspan=4 align=center style='width:1%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p><span style='font-size:8.0pt;'>${project.devPhase.maintenance}<span><o:p></o:p></span></span></p>
  </td>
 </tr>
 <tr>
  <td rowspan=3 colspan=4 valign=top style='width:1%;border:solid black .5pt;
  border-left:none;background:#FFFFFF;padding:0mm 0mm 0mm 0mm'>
  <p style='margin-left:2.0pt'><span style='font-size:8.0pt;'>${project.description}<span><o:p></o:p></span></span></p>
  </td>
 </tr>
 </#list>
 </table>
</div>
</div>
</body>
</html>