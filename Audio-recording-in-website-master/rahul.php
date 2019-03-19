<?php
$p_audio_name = $_FILES['data']['name'];
$p_audio_type = $_FILES['data']['type'];
$p_audio_temp = $_FILES['data']['tmp_name'];

$id1 = mt_rand(0, 9999999);
$id2 = mt_rand(0, 9999999);
$id3 = mt_rand(0, 9999999);
$id4 = mt_rand(0, 9999999);
$id5 = mt_rand(0, 9999999);
$id6 = mt_rand(0, 9999999);
$id7 = mt_rand(0, 9999999);
$id8 = mt_rand(0, 9999999);
$id9 = mt_rand(0, 9999999);
$id10 = mt_rand(0, 9999999);
$id11 = mt_rand(0, 9999999);

echo "Found it";
    //Conditionals
    if ($p_audio_type === "audio/wav" || $p_audio_type === "audio/wave" || $p_audio_type === "audio/x-wave" || $p_audio_type === "audio/vnd.wave"){$p_audio_type = ".wav";
     move_uploaded_file($p_audio_temp, "temp/".$id1.$id2.$id3.$id4.$id5.$id6.$id7.$id8.$id9.$id10.$id11.$p_audio_type);
   }
    if ($p_audio_type === "audio/wav" || $p_audio_type === "audio/wave" || $p_audio_type === "audio/x-wave" || $p_audio_type === "audio/vnd.wave"){$p_audio_type = ".wav";
     move_uploaded_file($p_audio_temp, "temp/".$id1.$id2.$id3.$id4.$id5.$id6.$id7.$id8.$id9.$id10.$id11.$p_audio_type);
   }

   ?>