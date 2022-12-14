PGDMP     3                
    z         	   ProbetoDB    15.0    15.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    24576 	   ProbetoDB    DATABASE        CREATE DATABASE "ProbetoDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'German_Germany.1252';
    DROP DATABASE "ProbetoDB";
                postgres    false                       0    0    DATABASE "ProbetoDB"    ACL     k   REVOKE CONNECT,TEMPORARY ON DATABASE "ProbetoDB" FROM PUBLIC;
GRANT ALL ON DATABASE "ProbetoDB" TO PUBLIC;
                   postgres    false    3345                        2615    24577    gso    SCHEMA        CREATE SCHEMA "gso";
    DROP SCHEMA "gso";
                postgres    false                       0    0    SCHEMA "public"    COMMENT     8   COMMENT ON SCHEMA "public" IS 'standard public schema';
                   pg_database_owner    false    5                        3079    16384 	   adminpack 	   EXTENSION     E   CREATE EXTENSION IF NOT EXISTS "adminpack" WITH SCHEMA "pg_catalog";
    DROP EXTENSION "adminpack";
                   false                       0    0    EXTENSION "adminpack"    COMMENT     O   COMMENT ON EXTENSION "adminpack" IS 'administrative functions for PostgreSQL';
                        false    2            Q           1247    24592    protkollstatus    TYPE     J   CREATE TYPE "public"."protkollstatus" AS ENUM (
    'done',
    'open'
);
 %   DROP TYPE "public"."protkollstatus";
       public          postgres    false            ?            1259    24578 	   protokoll    TABLE     *  CREATE TABLE "gso"."protokoll" (
    "id" integer NOT NULL,
    "date" timestamp without time zone,
    "description" "text",
    "title" "text",
    "protokollstatus" boolean,
    "konferenz" "text",
    "schuljahr" "date",
    "donedate" "date",
    "creationdate" "date",
    "rolle" boolean
);
    DROP TABLE "gso"."protokoll";
       gso         heap    postgres    false    7                       0    0    TABLE "protokoll"    ACL     0   GRANT ALL ON TABLE "gso"."protokoll" TO PUBLIC;
          gso          postgres    false    216            ?            1259    24609    protokoll_id_seq    SEQUENCE     ?   ALTER TABLE "gso"."protokoll" ALTER COLUMN "id" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME "gso"."protokoll_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            gso          postgres    false    216    7            ?            1259    24602    top    TABLE     z   CREATE TABLE "gso"."top" (
    "title" "text",
    "beschluss" "text",
    "id" integer NOT NULL,
    "notizen" "text"
);
    DROP TABLE "gso"."top";
       gso         heap    postgres    false    7                       0    0    TABLE "top"    ACL     *   GRANT ALL ON TABLE "gso"."top" TO PUBLIC;
          gso          postgres    false    219            ?            1259    24590    hibernate_sequence    SEQUENCE        CREATE SEQUENCE "public"."hibernate_sequence"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE "public"."hibernate_sequence";
       public          postgres    false            ?            1259    24585 	   protokoll    TABLE     c  CREATE TABLE "public"."protokoll" (
    "id" integer NOT NULL,
    "date" timestamp without time zone NOT NULL,
    "textfeld" character varying(255) NOT NULL,
    "creation_date" "date",
    "description" character varying(255),
    "done_date" "date",
    "protokoll_status" integer,
    "title" character varying(255),
    "protokollstatus" integer
);
 !   DROP TABLE "public"."protokoll";
       public         heap    postgres    false                      0    24578 	   protokoll 
   TABLE DATA                 gso          postgres    false    216          
          0    24602    top 
   TABLE DATA                 gso          postgres    false    219   B                 0    24585 	   protokoll 
   TABLE DATA                 public          postgres    false    217   \                  0    0    protokoll_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('"gso"."protokoll_id_seq"', 7, true);
          gso          postgres    false    220                       0    0    hibernate_sequence    SEQUENCE SET     E   SELECT pg_catalog.setval('"public"."hibernate_sequence"', 1, false);
          public          postgres    false    218            t           2606    24584    protokoll protokoll_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY "gso"."protokoll"
    ADD CONSTRAINT "protokoll_pkey" PRIMARY KEY ("id");
 E   ALTER TABLE ONLY "gso"."protokoll" DROP CONSTRAINT "protokoll_pkey";
       gso            postgres    false    216            x           2606    24608    top top_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY "gso"."top"
    ADD CONSTRAINT "top_pkey" PRIMARY KEY ("id");
 9   ALTER TABLE ONLY "gso"."top" DROP CONSTRAINT "top_pkey";
       gso            postgres    false    219            v           2606    24589    protokoll protokoll_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY "public"."protokoll"
    ADD CONSTRAINT "protokoll_pkey" PRIMARY KEY ("id");
 H   ALTER TABLE ONLY "public"."protokoll" DROP CONSTRAINT "protokoll_pkey";
       public            postgres    false    217                 x???Qk?0???????+??uuO?????=??M?`J???D,????J?r?sBN.??,Ls??? ?Sr? ??s??HSHU(4+?R4??VK?(f???
?Im?y???-dYw????	?-????B??Z?H?p8?i?????,?p???p????=?yO??(L???P?2[=_>%:t 9??T??Z????i?=?e?z	\o??k?a???$\??1???v??Yy?`?[0???&;=?(r=?????h??O?f?????$????$?/?X?/\h?b      
   
   x???             
   x???         