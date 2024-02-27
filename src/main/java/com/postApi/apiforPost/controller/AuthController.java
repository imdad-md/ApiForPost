//package com.postApi.apiforPost.controller;
//
//import com.postApi.apiforPost.repository.RoleRepository;
//import com.postApi.apiforPost.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
////    @Autowired
////    private UserRepository userRepository;
////
////    @Autowired
////    private RoleRepository roleRepository;
////
////    @Autowired
////    private PasswordEncoder passwordEncoder;
////
////    @Autowired
////    private AuthenticationManager authenticationManager;
////
////    // http://localhost:8080/api/auth/signin
////    @PostMapping("/signin")
////    public ResponseEntity <String> authenticateUser (@RequestBody LoginDto loginDto) {
////        Authentication authentication = authenticationManager.authenticate (new UsernamePasswordAuthenticationToken (loginDto.getUsernameOrEmail () , loginDto.getPassword ()));
////
////        SecurityContextHolder.getContext ().setAuthentication (authentication);
////        return new ResponseEntity <> ("User signed-in successfully!." , HttpStatus.OK);
////    }
////
////    //   http://localhost:8080/api/auth/signup
////    @PostMapping("/signup")
////    public ResponseEntity <?> registerUser (@RequestBody SignupDto signUpDto) {
////// add check for username exists in a DB
////        if (userRepository.existsByUsername (signUpDto.getUsername ())) {
////            return new ResponseEntity <> ("Username is already taken!" , HttpStatus.BAD_REQUEST);
////        }
////// add check for email exists in DB
////        if (userRepository.existsByEmail (signUpDto.getEmail ())) {
////            return new ResponseEntity <> ("Email is already taken!" , HttpStatus.BAD_REQUEST);
////        }
////// create user object
////        User user = new User ();
////        user.setName (signUpDto.getName ());
////        user.setUsername (signUpDto.getUsername ());
////        user.setEmail (signUpDto.getEmail ());
////        user.setPassword (passwordEncoder.encode (signUpDto.getPassword ()));
////        Role roles = roleRepository.findByName ("ROLE_ADMIN").get ();
////        user.setRoles (Collections.singleton (roles));
////        userRepository.save (user);
////        return new ResponseEntity <> ("User registered successfully" , HttpStatus.OK);
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
////    @Autowired
////    private JwtTokenProvider tokenProvider;
//
////    @PostMapping("/signin")
////    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto){
////        Authentication authentication = authenticationManager.authenticate(new
////                UsernamePasswordAuthenticationToken (
////                loginDto.getUsernameOrEmail(), loginDto.getPassword()));
////        SecurityContextHolder.getContext().setAuthentication(authentication);
////// get token form tokenProvider
////        String token = tokenProvider.generateToken(authentication);
////        return ResponseEntity.ok(new JWTAuthResponse (token));
////    }
////    @PostMapping("/signup")
////    public ResponseEntity<?> registerUser(@RequestBody SignupDto signUpDto){
////// add check for username exists in a DB
////        if(userRepository.existsByUsername(signUpDto.getUsername())){
////            return new ResponseEntity<>("Username is already taken!",
////                    HttpStatus.BAD_REQUEST);
////        }
////// add check for email exists in DB
////        if(userRepository.existsByEmail(signUpDto.getEmail())){
////            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
////        }
//// create user object
////        User user = new User();
////        user.setName(signUpDto.getName());
////        user.setUsername(signUpDto.getUsername());
////        user.setEmail(signUpDto.getEmail());
////        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
////        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
////        user.setRoles(Collections.singleton(roles));
////        userRepository.save(user);
////        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
////    }
//
//
//    }
//
