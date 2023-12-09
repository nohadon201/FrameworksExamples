<?php

namespace Database\Seeders;

// use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     */
    public function run(): void
    {
        DB::table('users')->insert([
            'name' => 'User1',
            'email' => 'user1@test.com',
            'email_verified_at' => now(),
            'password' => Hash::make('a'),
            'created_at' => now(),
            'updated_at' => now()
        ]);
        DB::table('users')->insert([
            'name' => 'User2',
            'email' => 'user2@test.com',
            'email_verified_at' => now(),
            'password' => Hash::make('a'),
            'created_at' => now(),
            'updated_at' => now()
        ]);


        //              SUPERZINGS
        
        
        
        DB::table('superzings')->insert([
            'Nom' => 'Superzing 1',
            'Empresonat' => false,
            'Perillos' => true,
            'numDiesPreso' => 9
        ]);
        DB::table('superzings')->insert([
            'Nom' => 'Superzing 2',
            'Empresonat' => true,
            'Perillos' => true,
            'numDiesPreso' => 9,
            'idUser'=>1
        ]);
        DB::table('superzings')->insert([
            'Nom' => 'Superzing 3',
            'Empresonat' => false,
            'Perillos' => false,
            'numDiesPreso' => 69
        ]);
        DB::table('superzings')->insert([
            'Nom' => 'Superzing 4',
            'Empresonat' => false,
            'Perillos' => false,
            'numDiesPreso' => 978
        ]);
        DB::table('superzings')->insert([
            'Nom' => 'Superzing 5',
            'Empresonat' => true,
            'Perillos' => true,
            'numDiesPreso' => 89,
            'idUser'=>2
        ]);
    }
}
